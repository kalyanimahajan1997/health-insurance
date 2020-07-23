 package controllers;

import beans.User;
import daos.QueryDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 public class QueryController extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     }
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
         if(op.equalsIgnoreCase("addQuery")){
            String msg = request.getParameter("msg");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
             QueryDao qd =  new QueryDao();
            if(qd.add(name, email, msg)){
                System.out.println("query updated!");
                response.sendRedirect("home.jsp");
            }
        } 
    
    }
    
    
 
}
