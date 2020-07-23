<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->
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
<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
<!-- //web-fonts -->
</head>
<body>
<script src='//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script><script src="//m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
<script>
(function(){
	if(typeof _bsa !== 'undefined' && _bsa) {
  		// format, zoneKey, segment:value, options
  		_bsa.init('flexbar', 'CKYI627U', 'placement:w3layoutscom');
  	}
})();
</script>
<script>
(function(){
if(typeof _bsa !== 'undefined' && _bsa) {
	// format, zoneKey, segment:value, options
	_bsa.init('fancybar', 'CKYDL2JN', 'placement:demo');
}
})();
</script>
<script>
(function(){
	if(typeof _bsa !== 'undefined' && _bsa) {
  		// format, zoneKey, segment:value, options
  		_bsa.init('stickybox', 'CKYI653J', 'placement:w3layoutscom');
  	}
})();
</script>
<!--<script>(function(v,d,o,ai){ai=d.createElement("script");ai.defer=true;ai.async=true;ai.src=v.location.protocol+o;d.head.appendChild(ai);})(window, document, "//a.vdo.ai/core/w3layouts_V2/vdo.ai.js?vdo=34");</script>-->
  	
<!-- Global site tag (gtag.js) - Google Analytics -->
 <script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-149859901-1');
</script>

<script>
     window.ga=window.ga||function(){(ga.q=ga.q||[]).push(arguments)};ga.l=+new Date;
     ga('create', 'UA-149859901-1', 'demo.w3layouts.com');
     ga('require', 'eventTracker');
     ga('require', 'outboundLinkTracker');
     ga('require', 'urlChangeTracker');
     ga('send', 'pageview');
   </script>
   <script async src='assets/js/autotrack.js'></script>

<meta name="robots" content="noindex">
<body><link rel="stylesheet" href="assets/css/demobar_w3_4thDec2019.css">
	<!-- Demo bar start -->
   
<div class="header">
    <jsp:include page="navbar.jsp"></jsp:include>	
	</div>
<!-- Slider -->
<div class="slider" id="home">
<jsp:include page="slider.jsp"></jsp:include>
</div>
<!-- //Slider -->				
<!-- bootstrap-modal-pop-up -->
	 
<!-- //bootstrap-modal-pop-up --> 
<!-- welcome -->
<div class="welcome" id="about">
<jsp:include page="about.jsp"></jsp:include>
 </div>
<!---728x90--->

<!-- //welcome -->

<!--/services-->
<div class="services" id="services">
<jsp:include page="services.jsp"></jsp:include>
</div>
<!---728x90--->
<!--//services-->
<!-- agents -->  
	<!-- //agents -->  
<!---728x90--->
<!-- Counter -->
<div class="stats">
<jsp:include page="counter.jsp"></jsp:include>
</div>
<!-- //Counter -->
<!-- testimonials -->
	<div class="testimonials" id="testimonials">
        <jsp:include page="testimonial.jsp"></jsp:include>
		</div>
<!-- //testimonials -->

<!-- contact -->
	<div id="contact" class="contact">
        <jsp:include page="contact.jsp"></jsp:include>
	</div>
	<!-- //contact -->

<!-- footer -->
<div class="footer_agile_w3ls">
<jsp:include page="footer.jsp"></jsp:include>
</div>
<div class="wthree_copy_right">
	<div class="container">
		<p>© 2018 Bank lock. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
	</div>
</div>
</body>
<!-- //footer -->
<!-- js-scripts -->					
<!-- js -->
<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.js"></script> <!-- Necessary-JavaScript-File-For-Bootstrap --> 
<!-- //js -->	

<!-- start-smoth-scrolling -->
<script src="js/SmoothScroll.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
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
				pager:false,
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
		$(document).on('ready', function() {
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