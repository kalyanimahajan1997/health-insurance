 
package controllers;

import utility.EmailSender;
import java.io.IOException;
 import beans.User;
import daos.UserDao;
 
 import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

 public class EmailController extends HttpServlet {
      
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              String host;
            String port;
            String user;
            String pass;
            //reads SMTP server setting from web.xml file 
            ServletContext context = getServletContext();
            host = context.getInitParameter("host");
            port = context.getInitParameter("port");
            user = context.getInitParameter("user");
            pass = context.getInitParameter("pass");
            
             HttpSession session = request.getSession();
            User u =  (User)session.getAttribute("user");
             //String mailTo = request.getParameter("email");
            String recipients= u.getEmail();   
             String message = "Your user id is : "+u.getEmail()+ " And password is : "+u.getPassword();
             String subject = "Reply by MyInsurance";
             
          try {
           EmailSender.sendEmail(host, port, user, pass,recipients, subject,message);
            String resultMessage = "The e-mail was sent successfully";
            response.sendRedirect("home.jsp");
              }
          catch (Exception ex) {
            ex.printStackTrace();
           String resultMessage = "There were an error: " + ex.getMessage();
        }  
          
 
    }
     
    
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
}        
      
  
}
