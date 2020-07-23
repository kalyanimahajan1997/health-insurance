 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <%
     String op = request.getParameter("op");
     if(op.equalsIgnoreCase("user")){
     session.removeAttribute("user");
     response.sendRedirect("login.jsp");
     }
     if(op.equalsIgnoreCase("admin")){
     session.removeAttribute("admin");
     response.sendRedirect("login.jsp");
         
     }
 %>