<%-- 
    Document   : home
    Created on : 19 Feb, 2020, 11:53:49 PM
    Author     : AKSHAY
--%>

 
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,beans.Admin,beans.User,daos.AdminDao,daos.UserDao"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login Page</title>
        <link rel="icon" type="image/ico" href="assets/images/c3.ico"> 

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="assets/css/shop-homepage.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/animate.min.css">

        <jsp:include page="base.jsp"></jsp:include>
        <style>
            body{
    background: -webkit-linear-gradient(left, #0072ff, #00c6ff);
}
.contact-form{
    background: #fff;
    margin-top: 10%;
    margin-bottom: 5%;
    width: 70%;
}
.contact-form .form-control{
    border-radius:1rem;
}
.contact-image{
    text-align: center;
}
.contact-image img{
    border-radius: 6rem;
    width: 11%;
    margin-top: -3%;
    transform: rotate(29deg);
}
.contact-form form{
    padding: 14%;
}
.contact-form form .row{
    margin-bottom: -7%;
}
.contact-form h3{
    margin-bottom: 8%;
    margin-top: -10%;
    text-align: center;
    color: #0062cc;
}
.contact-form .btnContact {
    width: 50%;
    border: none;
    border-radius: 1rem;
    padding: 1.5%;
    background: #dc3545;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
}
.btnContactSubmit
{
    width: 50%;
    border-radius: 1rem;
    padding: 1.5%;
    color: #fff;
    background-color: #0062cc;
    border: none;
    cursor: pointer;
}
       	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
        </style>
     
        <script> 
        function checkRole() { 
            var ele = document.getElementsByName('role'); 
            var userid = document.getElementById('userid');
            //alert(userid.value);
                for(i = 0; i < ele.length; i++) { 
                if(ele[i].checked){ 
                if((ele[i].value)=="admin"){
                    window.location.assign("admin/ForgetPassword.jsp?userid="+userid.value);
                }else if((ele[i].value)=="user"){
                    window.location.assign("user/ForgetPassword.jsp?userid="+userid.value);
                }
            } 
            } 
             } 
        
    </script>
         
        
        </head>

        <body>

            <!-- Navigation -->
           
            <!-- Page Content -->
            <div class="container contact-form">
            <div class="contact-image">
                <img src="assets/images/log.jpg" style=" transform: rotate(0deg)" alt="rocket_contact"/>
            </div>
               

<div class="login-form">
    <%
        Cookie cookies [] = request.getCookies();
        String userid="";
        String password="";
        
        for (Cookie c : cookies){
            if(c.getName().equals("userid"))
                userid= c.getValue();
            if (c.getName().equals("password"))
                password = c.getValue();
        }
        
        
        
    String msg = request.getParameter("msg");
    if(msg!=null)
        out.println("<font color='red' size='5' face='corbel'>"+msg+"</font>");
    %>
      <jsp:useBean class="beans.User" id="user" scope="session"></jsp:useBean>
     <form method="post">
     <jsp:setProperty name="user" property="*"></jsp:setProperty>
  
         <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input type="text" id="userid"  value="<%=userid%>" class="form-control" placeholder="userid" required="required" name="userid">
        </div>
        <div class="form-group">
            <input type="password" value="<%=password%>" class="form-control" placeholder="password" required="required" name="password"> 
        </div>
        <div class="bg-light" >
            <h6>Select Role</h6>
            <input type="radio" name="role" id="role1" value="admin"> <label for="admin">Admin</label>
              <input type="radio" name="role" id="role2" value="user"> <label for="user">User</label>
        </div>
         
        <div class="form-group">
            <button type="submit" name="submit" class="btn btn-primary btn-block">Log in</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox" name="remember" value="remember"> Remember me</label>
            <a href="#" onclick="checkRole();" id="forget" class="pull-right">Forgot Password?</a>
        </div>        
       
    </form>
    <p class="text-center"><a href="#">Create an Account</a></p>
</div>
                
                
    </div>
             
        <!-- /.container -->

        <!-- Footer -->
         <!-- Bootstrap core JavaScript -->
        <script src="assets/jquery/jquery.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>

        
         <% if(request.getParameter("submit")!=null){
           userid= request.getParameter("userid");
           password = request.getParameter("password");
           String role = request.getParameter("role");
           if(role==null){      
               response.sendRedirect("login.jsp?msg=Select any role");
           }
          else if(role.equals("admin")){
               AdminDao ado = new AdminDao();
               Admin admin = ado.getDetailsByLogin(userid, password);
                System.out.println("admin"+admin);
                System.out.println("name:"+admin.getName());
                System.out.println("image:"+admin.getImage());
               if(admin==null)
                   response.sendRedirect("login.jsp?msg=Invalid Userid or password");
               else {
                     String remember = null;
               remember = request.getParameter("remember");
               System.out.println("rem:"+remember);
              if (remember != null && remember.equalsIgnoreCase("remember")) {
                        Cookie c = new Cookie("userid", userid);
                        Cookie c2 = new Cookie("password", password);
                        c.setMaxAge(60 * 60 * 24);
                        c2.setMaxAge(60 * 60 * 24);
                        response.addCookie(c);
                        response.addCookie(c2);
                    }

                   session.setAttribute("admin", admin);
                   response.sendRedirect("admin/dashboard.jsp");
               }
               
           }
           else if(role.equals("user")){
           UserDao ud = new UserDao();
           int id = ud.isValid(userid, password);
           if(id!=-1)
           {
               String remember = null;
               remember = request.getParameter("remember");
               if (remember != null && remember.equalsIgnoreCase("remember")) {
                        Cookie c = new Cookie("userid", userid);
                        Cookie c2 = new Cookie("password", password);
                        c.setMaxAge(60 * 60 * 24);
                        c2.setMaxAge(60 * 60 * 24);
                        response.addCookie(c);
                        response.addCookie(c2);
                    }
               System.out.println("email:"+id);
               user = ud.getUserByUserId(id);
               System.out.println("user:"+user);
               session.setAttribute("user", user);
               response.sendRedirect("policyHolder/dashboard.jsp");
           }
           else
            response.sendRedirect("login.jsp?msg=Invalid Userid or Password");
          }
           
         
      }
        /* else
         {
              String role = request.getParameter("role");

              if(role==null){      
               response.sendRedirect("newsLogin.jsp?msg=Select any role");
              } else if(role.equals("admin")){
                  
              }
          
         }
  */
         %>

         
    </body>
 </html>
