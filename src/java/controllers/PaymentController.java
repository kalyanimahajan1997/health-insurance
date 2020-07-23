 package controllers;

import beans.PolicyHolder;
import beans.User;
import daos.ClaimDao;
import daos.PaymentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class PaymentController extends HttpServlet {

      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out  = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");
         HttpSession session = request.getSession();
         
         if(op.equalsIgnoreCase("claimingProcess")){
             System.out.println("==============");
             int cId = Integer.parseInt(request.getParameter("cId"));
             int amount = Integer.parseInt(request.getParameter("amount"));
             System.out.println("cid:"+cId);
             String status="success";
             LocalDate date = LocalDate.now();
             String claimed_date = date.toString();
             ClaimDao cd = new ClaimDao();
             if(cd.changeClaimStatus(cId, status)){
                 System.out.println("status changed successfully!");
                 response.sendRedirect("admin/allClaims.jsp");
             }
         }
         
          
         if(op.equalsIgnoreCase("renew")){
            // ArrayList<PolicyHolder> phList = (ArrayList<PolicyHolder>)session.getAttribute("phList");
             User user = (User)session.getAttribute("user");
             String mode = request.getParameter("mode");
             int amount  = (Integer.parseInt(request.getParameter("amount")));
             int phId  = (Integer.parseInt(request.getParameter("phId")));
             String status="success";
             LocalDate date = LocalDate.now();
             String payment_date = date.toString();
             PaymentDao pyd = new PaymentDao();
             String tId = pyd.generateTransId(12);
             int payId = pyd.addPaymentDetails(amount, payment_date, tId, status,mode);
             System.out.println("payId:"+payId);
              System.out.println("pId:"+phId);
                 if(pyd.addUserPaymentDetails(user.getId(),payId,phId)){
             System.out.println("renewed...!");
             response.sendRedirect("policyHolder/dashboard.jsp");
                  }
                }
         
         if(op.equalsIgnoreCase("firstPayment")){
              int amount  = (Integer.parseInt(request.getParameter("amount")));
               String mode = request.getParameter("mode");
             String status="success";
             LocalDate date = LocalDate.now();
             String payment_date = date.toString();
             PaymentDao pyd = new PaymentDao();
                  String tId = pyd.generateTransId(12);
      
             int payId = pyd.addPaymentDetails(amount, payment_date, tId, status,mode);
           session.setAttribute("payId", payId);
            
             System.out.println("your Payment has been successful!...!");
             
          response.sendRedirect("policyHolderController?op=add");
             }
         }
      }
 

