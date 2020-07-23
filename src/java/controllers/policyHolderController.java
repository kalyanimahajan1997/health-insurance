package controllers;

import beans.Policy;
import beans.PolicyHolder;
import beans.PolicyHolderAddress;
import beans.User;
import beans.demo;
import daos.PaymentDao;
import daos.PolicyHolderDao;
import daos.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import org.jboss.weld.servlet.SessionHolder;
import utility.FileUploader;

public class policyHolderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        System.out.println("op:" + op);
        HttpSession session = request.getSession();

        /*if(op!=null && op.equalsIgnoreCase("redirect")){
              
               session.setAttribute("request", request);
               response.sendRedirect("policyHolderDetails.jsp");
            System.out.println("request : "+session.getAttribute("request"));
              }*/
        if (op != null && op.equalsIgnoreCase("add")) {
             ArrayList<PolicyHolder> phList = new ArrayList();
           
             ArrayList<String> relation = new ArrayList();
              relation = (ArrayList<String>)session.getAttribute("relation");
             //PolicyHolder policyHolder = (PolicyHolder) session.getAttribute("policyHolder");
              phList = (ArrayList<PolicyHolder>)session.getAttribute("pHolderList");
                      
            PolicyHolderAddress pHolderAddr = (PolicyHolderAddress) session.getAttribute("policyHolderAddress");
            Policy policy = (Policy) session.getAttribute("policy");
            User user = (User) session.getAttribute("user");
            // System.out.println("userid in phController : " + user.getId());
            // UserDao ud = new UserDao();
            //user = ud.getUserByUserId(user.getEmail());
            //session.setAttribute("user", user);
            int userid = user.getId();
            System.out.println("userid in phController:" + user.getId());

            PolicyHolderDao ph = new PolicyHolderDao();
              int i=0;
            int size = relation.size();
            System.out.println("size:"+size);
            if(ph.addUserPolicyHolder(userid, policy)){
             System.out.println("================");
             int phId = ph.getPolicyHolderId();
            for(PolicyHolder policyHolder : phList){
              if (ph.addPolicyHolder(policyHolder, pHolderAddr, userid, policy,phId,relation)) {
                System.out.println("successfuly added!");
                if(size!=1){
                    relation.remove(i);
                    System.out.println("index in loop :"+relation.get(i));
                    
                     size--;
                }
              }
            }
            }
              
            int payId = (int)session.getAttribute("payId");
              PaymentDao pyd = new PaymentDao();
              int phId = ph.getPolicyHolderId();
             // ArrayList<PolicyHolder>pHolderList = ph.getPolicyHolderByUserId(user.getId());
             // for(PolicyHolder pHolder : pHolderList){
                 System.out.println("pId:"+phId);
                 if(pyd.addUserPaymentDetails(user.getId(),payId,phId)){
                     System.out.println("fully added!"); 
                 }
             //}
                 String password = ph.generateRandomPassword(10);
                 System.out.println("password:" + password);
                 user.setPassword(password);
                 session.setAttribute("user", user);
                 UserDao udo = new UserDao();
                 udo.setPassword(userid, password);

                //here we have to send userid and password to email
             
                session.removeAttribute("pHolderList");
                session.removeAttribute("pHolderAddr");
                session.removeAttribute("payId");
                UserDao ud = new UserDao();
                if(ud.isUserExist(user.getId())){
                 response.sendRedirect("home.jsp");
                }else{
                    response.sendRedirect("EmailController");
                }
                
               
            }
        
        
        }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("add")) {
            session = request.getSession();
           ArrayList<String> relation = new ArrayList();
          String rel = (String)session.getAttribute("relation");
            relation.add(rel);
          session.setAttribute("relation", relation);
            //session.setAttribute("request", request);
            //System.out.println("request : "+session.getAttribute("request"));
            PolicyHolder policyHolder = (PolicyHolder) session.getAttribute("policyHolder");

            ArrayList<String> imagePath = new ArrayList();
              ArrayList<PolicyHolder> pHolderList = new ArrayList();
            imagePath = FileUploader.getUploadedPath(getServletContext(), "media/policyHolder", request);

             String images = "";
            for (String image : imagePath) {
            policyHolder.setImage(image);
            }
              pHolderList.add(policyHolder); 
              session.setAttribute("pHolderList", pHolderList);
          

            response.sendRedirect("policyHolderDetails.jsp");

            /* PolicyHolder policyHolder = (PolicyHolder) session.getAttribute("policyHolder");
            PolicyHolderAddress pHolderAddr = (PolicyHolderAddress) session.getAttribute("policyHolderAddress");
            Policy policy = (Policy) session.getAttribute("policy");
            User user = (User) session.getAttribute("user");
            System.out.println("user name : " + user.getName());
            UserDao ud = new UserDao();
            user = ud.getUserByUserId(user.getEmail());
            session.setAttribute("user", user);
            int userid = user.getId();
            System.out.println("userid:" + user.getId());

            
            PolicyHolderDao ph = new PolicyHolderDao();
            String ImagePath = "";
            ImagePath = FileUploader.getUploadedPath(getServletContext(), "media/policyHolder", request);
            System.out.println("image:" + ImagePath);
            policyHolder.setImage(ImagePath);

            int amount = Integer.parseInt(policy.getMin_sum_assured())/100;
            if (ph.addPolicyHolder(policyHolder, pHolderAddr, userid, policy,amount)) {
                System.out.println("successfuly added!");
                session.removeAttribute("policyHolder");
                session.removeAttribute("pHolderAddr");
                response.sendRedirect("policyHolderDetails.jsp");

            }
             */
        }

        if (op != null && op.equalsIgnoreCase("addCouple")) {
            PolicyHolderAddress ph = (PolicyHolderAddress) session.getAttribute("policyHolderAddress");
            System.out.println("ph:" + ph.getCity());
            ArrayList<String> imagePath = new ArrayList();
            ArrayList<PolicyHolder> pHolderList = new ArrayList();
            imagePath = FileUploader.getUploadedPath(getServletContext(), "media/policyHolder", request);

          ArrayList<String> relation = new ArrayList();
          String rel1 = (String)session.getAttribute("rel1");
          String rel2 = (String)session.getAttribute("rel2");
            relation.add(rel1);
            relation.add(rel2);
            session.setAttribute("relation", relation);
          
            String images = "";
            for (String image : imagePath) {
                images += image + ",";
            }

            PolicyHolder policyHolder1 = (PolicyHolder) session.getAttribute("policyHolder1");
            PolicyHolder policyHolder2 = (PolicyHolder) session.getAttribute("policyHolder2");
            
            String[] imagesPath = images.split(",");
            System.out.println("qq:" + imagesPath[1]);
            policyHolder1.setImage(imagesPath[0].trim());
            policyHolder2.setImage(imagesPath[1].trim());
            
            pHolderList.add(policyHolder1);
            pHolderList.add(policyHolder2);
            session.setAttribute("pHolderList", pHolderList);
            response.sendRedirect("policyHolderDetails.jsp");

        }
        
        
        
        if (op != null && op.equalsIgnoreCase("addFamily1")) {
            PolicyHolderAddress ph = (PolicyHolderAddress) session.getAttribute("policyHolderAddress");
            System.out.println("ph:" + ph.getCity());
            ArrayList<String> imagePath = new ArrayList();
            ArrayList<PolicyHolder> pHolderList = new ArrayList();
            imagePath = FileUploader.getUploadedPath(getServletContext(), "media/policyHolder", request);

             ArrayList<String> relation = new ArrayList();
          String rel1 = (String)session.getAttribute("rel1");
          String rel2 = (String)session.getAttribute("rel2");
          String rel3 = (String)session.getAttribute("rel3");
            System.out.println("rel3:"+rel3);
          relation.add(rel1);
            relation.add(rel2);
            relation.add(rel3);
            session.setAttribute("relation", relation);
          
            
            String images = "";
            for (String image : imagePath) {
                images += image + ",";
            }

            PolicyHolder policyHolder1 = (PolicyHolder) session.getAttribute("policyHolder1");
            PolicyHolder policyHolder2 = (PolicyHolder) session.getAttribute("policyHolder2");
            PolicyHolder policyHolder3 = (PolicyHolder) session.getAttribute("policyHolder3");
            
            String[] imagesPath = images.split(",");
            System.out.println("qq:" + imagesPath[1]);
            policyHolder1.setImage(imagesPath[0].trim());
            policyHolder2.setImage(imagesPath[1].trim());
            policyHolder3.setImage(imagesPath[2].trim());
            pHolderList.add(policyHolder1);
            pHolderList.add(policyHolder2);
              pHolderList.add(policyHolder3);
            session.setAttribute("pHolderList", pHolderList);
            response.sendRedirect("policyHolderDetails.jsp");

        }

        if (op != null && op.equalsIgnoreCase("addFamily2")) {
            PolicyHolderAddress ph = (PolicyHolderAddress) session.getAttribute("policyHolderAddress");
            System.out.println("ph:" + ph.getCity());
            ArrayList<String> imagePath = new ArrayList();
            ArrayList<PolicyHolder> pHolderList = new ArrayList();
            imagePath = FileUploader.getUploadedPath(getServletContext(), "media/policyHolder", request);

              ArrayList<String> relation = new ArrayList();
          String rel1 = (String)session.getAttribute("rel1");
          String rel2 = (String)session.getAttribute("rel2");
          String rel3 = (String)session.getAttribute("rel3");
          String rel4 = (String)session.getAttribute("rel4");
         
          System.out.println("rel4:"+rel4);
          relation.add(rel1);
            relation.add(rel2);
            relation.add(rel3);
            relation.add(rel4);
            session.setAttribute("relation", relation);
          
           
            
            String images = "";
            for (String image : imagePath) {
                images += image + ",";
            }

            PolicyHolder policyHolder1 = (PolicyHolder) session.getAttribute("policyHolder1");
            PolicyHolder policyHolder2 = (PolicyHolder) session.getAttribute("policyHolder2");
            PolicyHolder policyHolder3 = (PolicyHolder) session.getAttribute("policyHolder3");
            PolicyHolder policyHolder4 = (PolicyHolder) session.getAttribute("policyHolder4");
            
            String[] imagesPath = images.split(",");
          //  System.out.println("qq:" + imagesPath[1]);
            policyHolder1.setImage(imagesPath[0].trim());
            policyHolder2.setImage(imagesPath[1].trim());
            policyHolder3.setImage(imagesPath[2].trim());
            policyHolder4.setImage(imagesPath[3].trim());
            
            pHolderList.add(policyHolder1);
            pHolderList.add(policyHolder2);
              pHolderList.add(policyHolder3);
             pHolderList.add(policyHolder4);
             
             session.setAttribute("pHolderList", pHolderList);
            response.sendRedirect("policyHolderDetails.jsp");

        }
        
    }

}
