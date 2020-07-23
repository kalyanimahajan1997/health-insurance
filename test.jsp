<%-- 
    Document   : test
    Created on : 7 Apr, 2020, 10:36:30 PM
    Author     : AKSHAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="beans.demo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>success</p>
        
       <%
           response.sendRedirect("policyHolderController?op=add");
       %>
       </body>
</html>
