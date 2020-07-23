<%@page import="daos.PolicyDao,beans.Policy"%>
<!--
        Author: W3layouts
        Author URL: http://w3layouts.com
        License: Creative Commons Attribution 3.0 Unported
        License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Policy Details</title>
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
        <link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <!-- //web-fonts -->
        <jsp:include page="base.jsp"></jsp:include>
 <script>
        function insureFor(){
             
        div1.style.display='block';
        }
     
        </script>
    </head>
    <body>

        <div class="header">
            <!--navbar -->
            <a href="home.jsp"></a>
            <!--end of navbar -->
        </div>

    <%
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id:" + id);
        PolicyDao pd = new PolicyDao();
        Policy policy = pd.getPolicyById(id);
        session.setAttribute("policy", policy);
    %>

    <div class="container">
        <div class="col-md-8 "> 
            <div class="row">                    
                <div class="card col col-md-8" style=" text-align: justify;
                     text-justify: inter-word;">
                    <div class="card-body">
                        <h2><%=policy.getName()%></h2><br>
                        <h4>Description</h4><br>
                        <p class="card-text"><%=policy.getDescription()%></p><br>
                        <br><h4>All Features</h4><br>
                        <div class="card col col-md-6" style=" text-align: justify;
                             text-justify: inter-word;  border: 2px solid black;">
                            <div class="card-body">

                                <p><b>Hospital Room Eligibility</b><br>
                                    Up to single private room permissible for hospitalization in this plan</p><br>

                                <p><b>Restoration of Cover</b>
                                    Full reinstatement of Sum Insured for a non-related illness if the original sum insured + no claim bonus exhausted once in policy year</p><br>

                                <p><b>Health Checkups</b>
                                    Health checkup permissible annually, in designated network</p>

                            </div>
                        </div>

                        <div class="card col col-md-6" style=" text-align: justify;
                             text-justify: inter-word; border: 2px solid black;">
                            <div class="card-body">

                                <p><b>Bonus on No Claim</b><br>
                                    Your health cover will increase every year and up to a maximum of 150% in 5 years as a reward for no claims</p><br>

                                <p><b>Share Claim Payments</b><br>
                                    Full claim paid by Insurer</p><br>

                                <p><b>Maternity</b><br>
                                    This plan doesn't provide coverage for maternity & related claims</p>

                            </div>
                        </div>
                    </div> 

                </div>
            </div>
        </div>
                        <div class="col-md-4" style="border: 2px solid black">
            <%
                int face_amount = Integer.parseInt(policy.getMin_sum_assured());
            %>
            <h2>Total Premium :   <%=(face_amount / 100)%>/-</h2><br>
            <h3>Sum Insured : <%=policy.getMin_sum_assured()%></h3><br>
            Covered for : <input type="button" value="1 Year" class="btn btn-group">
            <input type="button" value="2 Year" class="btn btn-group">
            <input type="button" value="3 Year" class="btn btn-group">
            
            <input type="button" value="proceed" class="btn btn-primary" onclick="insureFor();">
                  </div>
            
              <div class="col-md-4" id="div1" style="display: none">
                  <h2>Tell us who would you <b>Like to insure</b></h2>
                  <form action="UserController" method="get">
                  <input type="radio" name="planFor" value="self">Me<br>
                    <input type="radio" name="planFor" value="parents">My Parents<br>
                  <input type="radio" name="planFor" value="couple">Me & My Wife<br>
                  <input type="radio" name="planFor" value="family1">Me & My Wife & 1 kid<br>
                  <input type="radio" name="planFor" value="family2">Me & My Wife & 2 kid<br>
                    <input type="radio" name="planFor" value="others">Other Member<br>
                        
                    <input type="submit" name="submit" value="submit"><br>
                  
                  </form>
                        </div>

    </div>
    <!-- footer -->

    <!-- //footer -->
    <!-- js-scripts -->					
    <!-- js -->
    <script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
    <!-- //js -->	

    <!-- start-smoth-scrolling -->
    <script src="assets/js/SmoothScroll.min.js"></script>
    <script type="text/javascript" src="assets/js/move-top.js"></script>
    <script type="text/javascript" src="assets/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });
    </script>
    <!-- here stars scrolling icon -->
    <script type="text/javascript">
        $(document).ready(function () {
            /*
             var defaults = {
             containerID: 'toTop', // fading element id
             containerHoverID: 'toTopHover', // fading element hover id
             scrollSpeed: 1200,
             easingType: 'linear' 
             };
             */

            $().UItoTop({easingType: 'easeOutQuart'});

        });
    </script>
    <!-- //here ends scrolling icon -->
    <!-- start-smoth-scrolling -->

    <!-- Baneer-js -->
    <script src="assets/js/responsiveslides.min.js"></script>
    <script>
        $(function () {
            $("#slider").responsiveSlides({
                auto: true,
                pager: false,
                nav: true,
                speed: 1000,
                namespace: "callbacks",
                before: function () {
                    $('.events').append("<li>before event fired.</li>");
                },
                after: function () {
                    $('.events').append("<li>after event fired.</li>");
                }
            });
        });
    </script>
    <!-- //Baneer-js -->
    <!-- js for Counter -->
    <script type="text/javascript" src="assets/js/numscroller-1.0.js"></script>
    <!-- /js for Counter -->
    <!-- carousal -->
    <script src="assets/js/slick.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(document).on('ready', function () {
            $(".center").slick({
                dots: true,
                infinite: true,
                centerMode: true,
                slidesToShow: 2,
                slidesToScroll: 2,
                responsive: [
                    {
                        breakpoint: 768,
                        settings: {
                            arrows: true,
                            centerMode: false,
                            slidesToShow: 2
                        }
                    },
                    {
                        breakpoint: 480,
                        settings: {
                            arrows: true,
                            centerMode: false,
                            centerPadding: '40px',
                            slidesToShow: 1
                        }
                    }
                ]
            });
        });
    </script>
    <!-- //carousal -->

    <!-- //js-scripts -->
</body>
</html>