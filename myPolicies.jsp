<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page import="daos.PolicyDao,java.util.ArrayList,beans.Policy"%>
 <!DOCTYPE html>
<html lang="en">
<head>
<title>Health Insurance</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bank_lock  web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web Designs" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--// Meta tag Keywords -->

<!-- css files -->
<link rel="stylesheet" href="assets/css/bootstrap.css"> <!-- Bootstrap-Core-CSS -->
 
<link rel="stylesheet" href="assets/css/style.css" type="text/css" media="all" /> <!-- Style-CSS --> 
<link rel="stylesheet" href="assets/css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->

<!-- web-fonts -->
 <!-- //web-fonts -->

<jsp:include page="base.jsp"></jsp:include>
        <style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

</head>
<body>
    <script async src='assets/js/autotrack.js'></script>

<meta name="robots" content="noindex">
 <link rel="stylesheet" href="assets/css/demobar_w3_4thDec2019.css">
	<!-- Demo bar start -->
   
 
        <% 
    PolicyDao pd = new PolicyDao();
    ArrayList<Policy> policList = new ArrayList();
    policList = pd.getAllPolicy();
 %>
 <div class="container">
     <div class="col-md-12">
         <div class="row table-responsive">
             <select>
                 <option value="-1">select</option>
                 <option value="">All Plans</option>
                 <option value="">Individual Plans</option>
                 <option value="">Family Plans</option>
             </select><br>
             <table class="table" id="customers">
              <tr>
                 <td>Name</td><td>Sum Assured</td><td>Time Duration</td><td>Description</td>
             </tr>
               <tr>
                        <%for(Policy p : policList){%>
                        <td><%=p.getName()%></td>
                        <td><%=p.getMin_sum_assured()%></td> 
                        <td><%=p.getMin_time_duration()%></td>
                          <td><%=p.getDescription()%></td>
                          <td><a href="PolicyDetails.jsp?id=<%=p.getId()%>" class="btn btn-primary">View More</a></td> 
                </tr>
                <%}%>
             </table>
               
         </div>
     </div>
     
 </div>

<!-- Slider -->
 <!-- //Slider -->				
<!-- bootstrap-modal-pop-up -->
 
<!-- //bootstrap-modal-pop-up --> 
<!-- welcome -->
< 
<!---728x90--->

<!-- //welcome -->

<!--/services-->
 
<!---728x90--->
<!--//services-->
<!-- agents -->  
	<!-- //agents -->  
<!---728x90--->
<!-- Counter -->
 <!-- //Counter -->
<!-- testimonials -->
 
<!-- //testimonials -->

<!-- contact -->
 	<!-- //contact -->

<!-- footer -->
<div class="footer_agile_w3ls">
<jsp:include page="footer.jsp"></jsp:include>
</div>
 <!-- //footer -->
<!-- js-scripts -->					
<!-- js -->
<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
<!-- //js -->	

<!-- start-smoth-scrolling -->
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