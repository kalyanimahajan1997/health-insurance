package controllers;

import beans.Claim;

import beans.Hospital;
import beans.PolicyHolder;
import beans.User;
import daos.ClaimDao;

import daos.HospitalDao;
import daos.PolicyDao;
import daos.PolicyHolderDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.FileUploader;

public class ClaimController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (op.equalsIgnoreCase("acceptClaimRequest")) {
            int cId = Integer.parseInt(request.getParameter("cId"));
            ClaimDao cd = new ClaimDao();
            if (cd.changeClaimStatus(cId, "Accepted")) {
                out.println("<script>alert('Your claiming Request has been accepted!')</script>");
                response.sendRedirect("admin/allClaims.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (op.equalsIgnoreCase("claim")) {
            ArrayList<String> doc = FileUploader.getUploadedPath(getServletContext(), "media/policyHolder/docs", request);
            //System.out.println("file:"+doc);
            String docs = "";
            for (String d : doc) {
                docs += d + ",";
            }
            System.out.println("file:" + docs);

            LocalDate date = LocalDate.now();
            String claim_date = date.toString();
            String email = (String) session.getAttribute("email");
            System.out.println("email:" + email);
            PolicyHolderDao phd = new PolicyHolderDao();
            PolicyDao pd = new PolicyDao();
            PolicyHolder pHolder = phd.getPolicyHolderByUserId(email);
            System.out.println("phId:" + pHolder.getPhId());
            //int amount = pd.getSumByPolicyHolderId(pHolder.getPhId());

            String disease = (String) session.getAttribute("disease");
                    String doctorName = (String) session.getAttribute("doctor");
                    String admitDate = (String) session.getAttribute("admitDate");
                    String dischargeDate = (String) session.getAttribute("dischargeDate");
                    int billAmount = Integer.parseInt((String)session.getAttribute("billAmount"));
            
            ClaimDao cd = new ClaimDao();
            if (cd.add(claim_date, billAmount, pHolder.getPhId(), docs)) {
               
                //    response.sendRedirect("policyHolder/claim.jsp");

                Hospital hospital = (Hospital) session.getAttribute("hospital");
                HospitalDao hd = new HospitalDao();
                   
                    
                if (hd.add(hospital)) {
                    System.out.println("hospital data inserted!");

                    int hId = hd.getHospitalId();
                    System.out.println("hId:"+hId);
                    if (hd.addPHolderHospitalRecord(pHolder.getPhId(), hId, disease, doctorName)) {
                        System.out.println("hospital_disease_pHolder data inserted!");
                    }
                
                
                if(hd.addBill(billAmount,hId, admitDate, dischargeDate, pHolder.getPhId())){
                    System.out.println("bill added successfully done!");
                 }
                         System.out.println("claimed Successfuly...!");
                        session.removeAttribute(disease);
                        session.removeAttribute(doctorName);
                        session.removeAttribute(admitDate);
                        session.removeAttribute(dischargeDate);
                    
                }
                response.sendRedirect("policyHolder/dashboard.jsp");
            }
        }

        /*if (op.equalsIgnoreCase("otherDetails")) {
            int cId = Integer.parseInt(request.getParameter("cId"));
            String hName = request.getParameter("hName");
            String hAddress = request.getParameter("hAddress");
            String dName = request.getParameter("dName");
            String doctorName = request.getParameter("docName");
            String adminDate = request.getParameter("admin_date");
            String dischargeDate = request.getParameter("discharge_date");

            Hospital hospital = new Hospital();
            hospital.setName(hName);
            hospital.setAddress(hAddress);
            HospitalDao hd = new HospitalDao();
            if (hd.add(hospital)) {
                System.out.println("hospital data inserted!");
            }

            ClaimDao cd = new ClaimDao();
            Claim claim = cd.getClaimById(cId);

            if (hd.addBill(cId, cId, dName, dName, cId)) {
                System.out.println("bill data inserted!");
            }

            

        }*/
    }

}
