
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Payment  page</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Payment Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <link href="assets/css/style1.css" rel="stylesheet" type="text/css" media="all" />
        <link href='//fonts.googleapis.com/css?family=Fugaz+One' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Alegreya+Sans:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="assets/jquery/jquery.min.js"></script>
    </head>
    <body>
        <script src='//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script><script src="//m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
        <script>
            (function () {
                if (typeof _bsa !== 'undefined' && _bsa) {
                    // format, zoneKey, segment:value, options
                    _bsa.init('flexbar', 'CKYI627U', 'placement:w3layoutscom');
                }
            })();
        </script>
        <script>
            (function () {
                if (typeof _bsa !== 'undefined' && _bsa) {
                    // format, zoneKey, segment:value, options
                    _bsa.init('fancybar', 'CKYDL2JN', 'placement:demo');
                }
            })();
        </script>
        <script>
            (function () {
                if (typeof _bsa !== 'undefined' && _bsa) {
                    // format, zoneKey, segment:value, options
                    _bsa.init('stickybox', 'CKYI653J', 'placement:w3layoutscom');
                }
            })();
        </script>
        <!--<script>(function(v,d,o,ai){ai=d.createElement("script");ai.defer=true;ai.async=true;ai.src=v.location.protocol+o;d.head.appendChild(ai);})(window, document, "//a.vdo.ai/core/w3layouts_V2/vdo.ai.js?vdo=34");</script>-->
        <div id="codefund"><!-- fallback content --></div>
        <script src="https://codefund.io/properties/441/funder.js" async="async"></script>

        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src='https://www.googletagmanager.com/gtag/js?id=UA-149859901-1'></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);}
            gtag('js', new Date());

            gtag('config', 'UA-149859901-1');
        </script>

        <script>
            window.ga = window.ga || function () {
                (ga.q = ga.q || []).push(arguments)
            };
            ga.l = +new Date;
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
          

        <div class="main">
            <h1>Make Payment</h1>
            <!---728x90--->


            <div class="content">

                <script src="assets/js/easyResponsiveTabs.js" type="text/javascript"></script>
                <script type="text/javascript">
$(document).ready(function () {
$('#horizontalTab').easyResponsiveTabs({
type: 'default', //Types: default, vertical, accordion           
width: 'auto', //auto or any width like 600px
fit: true   // 100% fit in a container
});
});

                </script>
                <div class="sap_tabs">
                    <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
                        <div class="pay-tabs">
                            <h2>Select Payment Method</h2>
                            <ul class="resp-tabs-list">
                                <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span><label class="pic1"></label>Credit Card</span></li>
                                <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span><label class="pic3"></label>Net Banking</span></li>
                                 <li class="resp-tab-item" aria-controls="tab_item-3" role="tab"><span><label class="pic2"></label>Debit Card</span></li>
                                <div class="clear"></div>
                            </ul>	
                        </div>
                        
                        <%
                            String op = request.getParameter("op");
                            if(op.equalsIgnoreCase("claimConfirmation")){
                         int amount = (Integer.parseInt(request.getParameter("amount")));
                         int cId = Integer.parseInt(request.getParameter("cId"));
                              %>
                              
                            <h1>claim Confirmation page</h1>
                            <div class="resp-tabs-container">
                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                <div class="payment-info">
                                    <h3>Personal Information</h3>
                                    <form>
                                        <div class="tab-for">				
                                            <h5>EMAIL ADDRESS</h5>
                                            <input type="text" value="">
                                            <h5>FIRST NAME</h5>													
                                            <input type="text" value="">
                                        </div>			
                                    </form>
                                    <h3 class="pay-title">Credit Card Info</h3>
                                    <form>
                                        <div class="tab-for">				
                                            <h5>NAME ON CARD</h5>
                                            <input type="text" value="">
                                            <h5>CARD NUMBER</h5>													
                                            <input class="pay-logo" type="text" value="0000-0000-0000-0000" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = '0000-0000-0000-0000';
                                                                                                                        }" required="">
                                        </div>	
                                        <div class="transaction">
                                            <div class="tab-form-left user-form">
                                                <h5>EXPIRATION</h5>
                                                <ul>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="6" min="1" />	
                                                    </li>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="1988" min="1" />	
                                                    </li>

                                                </ul>
                                            </div>
                                            <div class="tab-form-right user-form-rt">
                                                <h5>CVV NUMBER</h5>													
                                                <input type="text" value="xxxx" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = 'xxxx';}" required="">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <input type="submit" value="SUBMIT">
                                    </form>
                                    <div class="single-bottom">
                                        <ul>
                                            <li>
                                                <input type="checkbox"  id="brand" value="">
                                                <label for="brand"><span></span>By checking this box, I agree to the Terms & Conditions & Privacy Policy.</label>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
                                <div class="payment-info">
                                    <h3>Net Banking</h3>
                                    <div class="radio-btns">
                                        <div class="swit">								
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Andhra Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Allahabad Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Bank of Baroda</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Canara Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IDBI Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Icici Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Overseas Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Punjab National Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>South Indian Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>State Bank Of India</label> </div></div>		
                                        </div>
                                        <div class="swit">								
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>City Union Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>HDFC Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IndusInd Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Syndicate Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Deutsche Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Corporation Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>UCO Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Federal Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>ING Vysya Bank</label> </div></div>	
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <a href="#">Continue</a>
                                </div>
                            </div>
                        
                              <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-3">	
                                <div class="payment-info">

                                    <h3 class="pay-title">Debit Card Info</h3>
                                    <form action="PaymentController?op=claimingProcess&cId=<%=cId%>&amount=<%=amount%>" method="post">
                                        <div class="tab-for">				
                                            <h5>NAME ON CARD</h5>
                                            <input type="text" value="">
                                            <h5>CARD NUMBER</h5>													
                                            <input class="pay-logo" type="text" value="0000-0000-0000-0000" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = '0000-0000-0000-0000';
                                                                                                                        }" required="">
                                        </div>	
                                        <div class="transaction">
                                            <div class="tab-form-left user-form">
                                                <h5>EXPIRATION</h5>
                                                <ul>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="6" min="1" />	
                                                    </li>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="1988" min="1" />	
                                                    </li>

                                                </ul>
                                            </div>
                                            <div class="tab-form-right user-form-rt">
                                                <h5>CVV NUMBER</h5>													
                                                <input type="text" value="xxxx" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = 'xxxx';}" required="">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <input type="submit" name="submit"   value="SUBMIT">
                                    </form>
                                    <div class="single-bottom">
                                        <ul>
                                            <li>
                                                <input type="checkbox"  id="brand" value="">
                                                <label for="brand"><span></span>By checking this box, I agree to the Terms & Conditions & Privacy Policy.</label>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            
                            <%}
                            
                            
                            if(op.equalsIgnoreCase("renew")){
                               int amount = (Integer.parseInt(request.getParameter("payAmount")));
                               int phId = (Integer.parseInt(request.getParameter("phId")));
                        %>
                             <div class="resp-tabs-container">
                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                <div class="payment-info">
                                    <h3>Personal Information</h3>
                                    <form>
                                        <div class="tab-for">				
                                            <h5>EMAIL ADDRESS</h5>
                                            <input type="text" value="">
                                            <h5>FIRST NAME</h5>													
                                            <input type="text" value="">
                                        </div>			
                                    </form>
                                    <h3 class="pay-title">Credit Card Info</h3>
                                    <form>
                                        <div class="tab-for">				
                                            <h5>NAME ON CARD</h5>
                                            <input type="text" value="">
                                            <h5>CARD NUMBER</h5>													
                                            <input class="pay-logo" type="text" value="0000-0000-0000-0000" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = '0000-0000-0000-0000';
                                                                                                                        }" required="">
                                        </div>	
                                        <div class="transaction">
                                            <div class="tab-form-left user-form">
                                                <h5>EXPIRATION</h5>
                                                <ul>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="6" min="1" />	
                                                    </li>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="1988" min="1" />	
                                                    </li>

                                                </ul>
                                            </div>
                                            <div class="tab-form-right user-form-rt">
                                                <h5>CVV NUMBER</h5>													
                                                <input type="text" value="xxxx" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = 'xxxx';}" required="">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <input type="submit" value="SUBMIT">
                                    </form>
                                    <div class="single-bottom">
                                        <ul>
                                            <li>
                                                <input type="checkbox"  id="brand" value="">
                                                <label for="brand"><span></span>By checking this box, I agree to the Terms & Conditions & Privacy Policy.</label>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
                                <div class="payment-info">
                                    <h3>Net Banking</h3>
                                    <div class="radio-btns">
                                        <div class="swit">								
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Andhra Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Allahabad Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Bank of Baroda</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Canara Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IDBI Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Icici Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Overseas Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Punjab National Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>South Indian Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>State Bank Of India</label> </div></div>		
                                        </div>
                                        <div class="swit">								
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>City Union Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>HDFC Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IndusInd Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Syndicate Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Deutsche Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Corporation Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>UCO Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Federal Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>ING Vysya Bank</label> </div></div>	
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <a href="#">Continue</a>
                                </div>
                            </div>
                        
                              <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-3">	
                                <div class="payment-info">

                                    <h3 class="pay-title">Debit Card Info</h3>
                                    <form action="PaymentController?op=renew&phId=<%=phId%>&amount=<%=amount%>&mode=debit cart" method="post">
                                        <div class="tab-for">				
                                            <h5>NAME ON CARD</h5>
                                            <input type="text" value="">
                                            <h5>CARD NUMBER</h5>													
                                            <input class="pay-logo" type="text" value="0000-0000-0000-0000" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = '0000-0000-0000-0000';
                                                                                                                        }" required="">
                                        </div>	
                                        <div class="transaction">
                                            <div class="tab-form-left user-form">
                                                <h5>EXPIRATION</h5>
                                                <ul>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="6" min="1" />	
                                                    </li>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="1988" min="1" />	
                                                    </li>

                                                </ul>
                                            </div>
                                            <div class="tab-form-right user-form-rt">
                                                <h5>CVV NUMBER</h5>													
                                                <input type="text" value="xxxx" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = 'xxxx';}" required="">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <input type="submit" name="submit"   value="SUBMIT">
                                    </form>
                                    <div class="single-bottom">
                                        <ul>
                                            <li>
                                                <input type="checkbox"  id="brand" value="">
                                                <label for="brand"><span></span>By checking this box, I agree to the Terms & Conditions & Privacy Policy.</label>
                                            </li>
                                        </ul>
                                    </div>
                                </div>  
                            <%}
                            if(op.equalsIgnoreCase("firstPayment")){
                               int amount = (Integer.parseInt(request.getParameter("amount")));
                         %>
                        
                         <div class="resp-tabs-container">
                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                <div class="payment-info">
                                    <h3>Personal Information</h3>
                                    <form>
                                        <div class="tab-for">				
                                            <h5>EMAIL ADDRESS</h5>
                                            <input type="text" value="">
                                            <h5>FIRST NAME</h5>													
                                            <input type="text" value="">
                                        </div>			
                                    </form>
                                    <h3 class="pay-title">Credit Card Info</h3>
                                    <form>
                                        <div class="tab-for">				
                                            <h5>NAME ON CARD</h5>
                                            <input type="text" value="">
                                            <h5>CARD NUMBER</h5>													
                                            <input class="pay-logo" type="text" value="0000-0000-0000-0000" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = '0000-0000-0000-0000';
                                                                                                                        }" required="">
                                        </div>	
                                        <div class="transaction">
                                            <div class="tab-form-left user-form">
                                                <h5>EXPIRATION</h5>
                                                <ul>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="6" min="1" />	
                                                    </li>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="1988" min="1" />	
                                                    </li>

                                                </ul>
                                            </div>
                                            <div class="tab-form-right user-form-rt">
                                                <h5>CVV NUMBER</h5>													
                                                <input type="text" value="xxxx" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = 'xxxx';}" required="">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <input type="submit" value="SUBMIT">
                                    </form>
                                    <div class="single-bottom">
                                        <ul>
                                            <li>
                                                <input type="checkbox"  id="brand" value="">
                                                <label for="brand"><span></span>By checking this box, I agree to the Terms & Conditions & Privacy Policy.</label>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-1">
                                <div class="payment-info">
                                    <h3>Net Banking</h3>
                                    <div class="radio-btns">
                                        <div class="swit">								
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Andhra Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Allahabad Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Bank of Baroda</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Canara Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IDBI Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Icici Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Overseas Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Punjab National Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>South Indian Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>State Bank Of India</label> </div></div>		
                                        </div>
                                        <div class="swit">								
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>City Union Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>HDFC Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IndusInd Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Syndicate Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Deutsche Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Corporation Bank</label> </div></div>
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>UCO Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Federal Bank</label> </div></div>	
                                            <div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>ING Vysya Bank</label> </div></div>	
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <a href="#">Continue</a>
                                </div>
                            </div>
                             <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-3">	
                                <div class="payment-info">

                                    <h3 class="pay-title">Dedit Card Info</h3>
                                    <form action="PaymentController?op=firstPayment&amount=<%=amount%>&mode=debit cart" method="post">
                                        <div class="tab-for">				
                                            <h5>NAME ON CARD</h5>
                                            <input type="text" value="">
                                            <h5>CARD NUMBER</h5>													
                                            <input class="pay-logo" type="text" value="0000-0000-0000-0000" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = '0000-0000-0000-0000';
                                                                                                                        }" required="">
                                        </div>	
                                        <div class="transaction">
                                            <div class="tab-form-left user-form">
                                                <h5>EXPIRATION</h5>
                                                <ul>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="6" min="1" />	
                                                    </li>
                                                    <li>
                                                        <input type="number" class="text_box" type="text" value="1988" min="1" />	
                                                    </li>

                                                </ul>
                                            </div>
                                            <div class="tab-form-right user-form-rt">
                                                <h5>CVV NUMBER</h5>													
                                                <input type="text" value="xxxx" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                                            this.value = 'xxxx';}" required="">
                                            </div>
                                            <div class="clear"></div>
                                        </div>
                                        <input type="submit" name="submit"   value="SUBMIT">
                                    </form>
                                    <div class="single-bottom">
                                        <ul>
                                            <li>
                                                <input type="checkbox"  id="brand" value="">
                                                <label for="brand"><span></span>By checking this box, I agree to the Terms & Conditions & Privacy Policy.</label>
                                            </li>
                                        </ul>
                                    </div>
                                </div>	
                            </div>
                        </div>	
                    </div>
                </div>	

            </div>
            <!---728x90--->
            <%}%>


            <a class="btn btn-primary" href="#" >Back</a>

        </div>
    </body>
</html>