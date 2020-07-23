<%@page import="beans.User"%>
<%@page import="beans.Policy"%>
 <!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bank_lock a Banking Category Flat Bootstrap Responsive Website Template | Home :: W3layouts</title>
        <!-- Meta tag Keywords -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Bank_lock  web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web Designs" />
         <!-- css files -->
        <link rel="stylesheet" href="assets/css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
        <link rel="stylesheet" href="assets/css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
        <link rel="stylesheet" href="assets/css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
        <!-- //css files -->

        <!-- web-fonts -->
         <!-- //web-fonts -->
        <jsp:include page="base.jsp"></jsp:include>
         <script>
        function displayDiv3(){
             div3.style.display="block";
        }
    </script>
    </head>
    <body>
              <script async src='assets/js/autotrack.js'></script>

           
        <jsp:useBean class="beans.PolicyHolder" id="policyHolder1" scope="session"></jsp:useBean>     
        <jsp:useBean class="beans.PolicyHolder" id="policyHolder2" scope="session"></jsp:useBean>     
        
            <div class="container">
                <div class="row">
                    <div class="col">
                    <center><a href="home.jsp" class="btn btn-primary">Back To Home</a></center><br>
                    <div class="col col-md-9" id="div1">
                        <%
                            Policy policy = (Policy) session.getAttribute("policy");
                            String plansFor = (String) session.getAttribute("plan");
                        %>
                        <input type="text" name="planFor" value="<%=plansFor%>" readonly="">
                        <input type="text" name="name" value="<%=policy.getName()%>" readonly="">
                        <input type="text" name="sumInsured" value="sum insured:<%=policy.getMin_sum_assured()%>" readonly="">
                        <input type="text" name="premium" value="premium:<%=Integer.parseInt(policy.getMin_sum_assured()) / 100%>" readonly=""><br>
                    </div>
                        <%
                            User user = (User)session.getAttribute("user");
                        %>
                    <div class="col col-md-9" id="div2">
                        <br><h4><b>Father</b></h4>
                        <form class="form"> 
                            <br>Enter Your Name : <input type="text" name="name" value="${policyHolder1.name}" class="form-control">
                            <br>Enter Father's Name : <input type="text" name="fname" value="${policyHolder1.fname}" class="form-control">
                            <br>Enter Your Email : <input type="email" name="email" value="${policyHolder1.email}" class="form-control">
                            <br>Enter Your Contact : <input type="text" maxlength="10" name="contact" value="${policyHolder1.contact}" class="form-control">
                            <br>Enter Your Dob : <input type="date" name="dob" value="${policyHolder1.dob}" class="form-control">
                            <br>Select Your Gender : <input type="radio" name="gender" value="male"  ${policyHolder1.gender eq "male" ? "checked":""}>Male
                            <input type="radio" name="gender" value="female" ${policyHolder1.gender eq "female" ? "checked":""}>Female<br>

                            <br>Select Your Occupation : <select name="occupation" class="form-control">
                                <option>select</option> <option>salaried</option> <option>self employed</option>
                                <option>student</option> <option>retired</option> <option>house wife</option>
                            </select>
                            <br> <input type="submit" name="submit1" class="btn btn-warning" value="Next">                          

                        </form>

                    </div>

                    <div class="col-md-9" id="div3"  >
                           <% if (request.getParameter("submit1") != null) {
                               session.setAttribute("rel1", "father");
                                                System.out.println("===" + request.getParameter("submit1"));%>
                        <jsp:setProperty name="policyHolder1" property="*"></jsp:setProperty>
                         <br><h4><b>Mother</b></h4>
                         <form class="form" action="parentsAddress.jsp"> 
                            <br>Enter Your Name : <input type="text" name="name" value="${policyHolder2.name}" class="form-control">
                            <br>Enter Father's Name : <input type="text" name="fname" value="${policyHolder2.fname}" class="form-control">
                            <br>Enter Your Email : <input type="email" name="email" value="${policyHolder2.email}" class="form-control">
                            <br>Enter Your Contact : <input type="text" maxlength="10" name="contact" value="${policyHolder2.contact}" class="form-control">
                            <br>Enter Your Dob : <input type="date" name="dob" value="${policyHolder2.dob}" class="form-control">
                            <br>Select Your Gender : <input type="radio" name="gender" value="male"  ${policyHolder2.gender eq "male" ? "checked":""}>Male
                            <input type="radio" name="gender" value="female" ${policyHolder2.gender eq "female" ? "checked":""}>Female<br>

                            <br>Select Your Occupation : <select name="occupation" class="form-control">
                                <option>select</option> <option>salaried</option> <option>self employed</option>
                                <option>student</option> <option>retired</option> <option>house wife</option>
                            </select>
                            <br> <input type="submit" name="submit2" class="btn btn-warning" value="Next">                        

                        </form>

                    </div>
                </div>
            </div>
        </div>
         
       <%                  }
         System.out.println("name1:"+policyHolder1.getName());
System.out.println("name2:"+policyHolder2.getName());
         %>
                       
         <!-- js -->
        <script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
        <!-- //js -->	

        <!-- start-smoth-scrolling -->
        <script src="assets/js/SmoothScroll.min.js"></script>
        <script type="text/javascript" src="assets/js/move-top.js"></script>
        <script type="text/javascript" src="assets/js/easing.js"></script>
         <!-- //here ends scrolling icon -->
        <!-- start-smoth-scrolling -->

        <!-- Baneer-js -->
        <script src="assets/js/responsiveslides.min.js"></script>
         <!-- //Baneer-js -->
        <!-- js for Counter -->
        <script type="text/javascript" src="assets/js/numscroller-1.0.js"></script>
        <!-- /js for Counter -->
        <!-- carousal -->
        <script src="assets/js/slick.js" type="text/javascript" charset="utf-8"></script>
         <!-- //carousal -->

        <!-- //js-scripts -->
    </body>
</html>