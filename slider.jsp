<%@page import="beans.User"%>  
<head>
    <script>
        function openRegisterForm() {
            register.style.display = "block";
            b1.style.display = 'none';
        }
    </script>
</head>
<div class="slider" id="home">
    <div class="callbacks_container">
        <ul class="rslides" id="slider">
            <li>
                     <div class="banner-dott">
                         <img src="assets/images/s1.jpg">
                     </div>
                      
              
            </li>
            <li>
                <div class="w3layouts-banner-top">
                         <div class="banner-dott">
                         <img src="assets/images/s2.jpg">
                     </div>
                
                </div>
            </li>
            <li>
                <div class="w3layouts-banner-top w3layouts-banner-top3">
                         <div class="banner-dott">
                         <img src="assets/images/s3.jpg">
                     </div>
                
                </div>
            </li>
        </ul>
    </div>
    <jsp:useBean id="user" class="beans.User" scope="session"></jsp:useBean>

        <div class="clearfix">
        <div class="main add" id="b1">
            <center><button class="btn btn-primary" style="width: 100px; height: 70px;" onclick="openRegisterForm();" >View Plans</button></center>
        </div>
        <div class="main add" id="register" style="display: none">

            <h2>Register For Free Account</h2>
        <jsp:setProperty name="user" property="*"></jsp:setProperty>
        <form action="UserController?op=add" method="post">
            <h5>Username</h5>
            <input type="text" name="name" Placeholder="Type here" required="">
            <h5>Email</h5>
            <input type="email" name="email" Placeholder="johnkeith@mail.com"  required="">
            <h5>Contact</h5>
            <input type="text" name="contact"  Placeholder="Type here" maxlength="10" required="">

            <input type="submit" name="submit" Placeholder="Create Account">
        </form>
    </div>
</div>
</div>