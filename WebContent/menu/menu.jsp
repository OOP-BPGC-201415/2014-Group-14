<%@page import="java.text.*"%>
<%@page import="web.*"%>
<%@page import="actors.*"%>
<%@page import="backend.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if (IE 9)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!--> <html lang="en-US"> <!--<![endif]-->
<head>

<!-- Meta Tags -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>Menu</title>   

<meta name="description" content="Insert Your Site Description" /> 

<!-- Mobile Specifics -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="HandheldFriendly" content="true"/>
<meta name="MobileOptimized" content="320"/>   

<!-- Mobile Internet Explorer ClearType Technology -->
<!--[if IEMobile]>  <meta http-equiv="cleartype" content="on">  <![endif]-->

<!-- Bootstrap -->
<link href="_include/css/bootstrap.min.css" rel="stylesheet">

<!-- Main Style -->
<link href="_include/css/main.css" rel="stylesheet">

<!-- Supersized -->
<link href="_include/css/supersized.css" rel="stylesheet">
<link href="_include/css/supersized.shutter.css" rel="stylesheet">

<!-- FancyBox -->
<link href="_include/css/fancybox/jquery.fancybox.css" rel="stylesheet">

<!-- Font Icons -->
<link href="_include/css/fonts.css" rel="stylesheet">

<!-- Shortcodes -->
<link href="_include/css/shortcodes.css" rel="stylesheet">

<!-- Responsive -->
<link href="_include/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="_include/css/responsive.css" rel="stylesheet">

<!-- Google Font -->
<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,200italic,300,300italic,400italic,600,600italic,700,700italic,900' rel='stylesheet' type='text/css'>

<!-- Fav Icon -->
<link rel="shortcut icon" href="#">

<link rel="apple-touch-icon" href="#">
<link rel="apple-touch-icon" sizes="114x114" href="#">
<link rel="apple-touch-icon" sizes="72x72" href="#">
<link rel="apple-touch-icon" sizes="144x144" href="#">

<!-- Modernizr -->
<script src="_include/js/modernizr.js"></script>

<!-- Analytics -->
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'Insert Your Code']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
<!-- End Analytics -->

</head>


<body>

<!-- This section is for Splash Screen -->
<!-- <section id="jSplash">
	<div id="circle"></div>
</section> -->
<!-- End of Splash Screen -->

<!-- Homepage Slider -->
<div id="home-slider">	
<!-- 	<div class="overlay"></div> -->
    
    <div class="slider-text">
    	<div ><h1>Menu</i></h1></div>
    </div>   
	
	<div class="control-nav">
      <!--   <a id="prevslide" class="load-item"><i class="font-icon-arrow-simple-left"></i></a>
        <a id="nextslide" class="load-item"><i class="font-icon-arrow-simple-right"></i></a>
        <ul id="slide-list"></ul> -->
        
        <a id="nextsection" href="#shortcodes"><i class="font-icon-arrow-simple-down"></i></a>
    </div>
</div>
<!-- End Homepage Slider -->

<!-- Header -->
<header>
    <div class="sticky-nav">
    	<a id="mobile-nav" class="menu-nav" href="#menu-nav"></a>
        
       
        
        <nav id="menu">
        	<ul id="menu-nav">
            	<li><a href="#home-slider" class="external">Home</a></li>
                <li><a href="../swd/swd.jsp" class="external">SWD</a></li>
                <li class="current"><a class="external" href="../log-in/index.html">Login</a></li>
            </ul>
        </nav>
        
    </div>
</header>
<!-- End Header -->

<!-- Our Shortcodes Section -->
<div id="shortcodes" class="page">
	<div class="container">
    
    	<!-- Title Page -->
        <div class="row">
            <div class="span12">
                <div class="title-page">
                    <h2 class="title">Food</h2>
                    <h3 class="title-description">Useful and Indispensable.</h3>
                </div>
            </div>
        </div>
        <!-- End Title Page -->
        
        <!-- Start Accordion/Toggle Section -->
        <div class="row">
        
        	<div class="span6">
            	<h3 >Unleash Your Taste Buds!</h3>
                <% Menu m = Menu.getMenu(); %>
            	<!-- Start Accordion -->
        		<div class="accordion" id="accordionArea">
                    <div class="accordion-group">
                        <div class="accordion-heading accordionize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionArea" href="#oneArea">
                                Monday
                                <span class="font-icon-arrow-simple-down"></span>
                            </a>
                        </div>
                        <div id="oneArea" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="accordion-group">
                        <div class="accordion-heading accordionize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionArea" href="#twoArea">
                            Tuesday
                            <span class="font-icon-arrow-simple-down"></span>
                        </a>
                        </div>
                        <div id="twoArea" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="accordion-group">
                        <div class="accordion-heading accordionize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionArea" href="#threeArea">
                            Wednesday
                            <span class="font-icon-arrow-simple-down"></span>
                        </a>
                        </div>
                        <div id="threeArea" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading accordionize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordionArea" href="#fourArea">
                          Thursday
                            <span class="font-icon-arrow-simple-down"></span>
                        </a>
                        </div>
                        <div id="fourArea" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
            	</div>

                <!-- End Accordion -->
        	</div>
            
            <div class="span6">
            	<h3>And I forgot it was Mess Food.</h3>
                
            	<!-- Start Toggle -->
                <div class="accordion" id="toggleArea">
                
                    <div class="accordion-group">
                        <div class="accordion-heading togglize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#" href="#collapseOne">
                                Friday
                                <span class="font-icon-plus"></span>
                                <span class="font-icon-minus"></span>
                            </a>
                        </div>
                        <div id="collapseOne" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="accordion-group">
                        <div class="accordion-heading togglize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#" href="#collapseTwo">
                            Saturday
                            <span class="font-icon-plus"></span>
                            <span class="font-icon-minus"></span>
                        </a>
                        </div>
                        <div id="collapseTwo" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="accordion-group">
                        <div class="accordion-heading togglize">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#" href="#collapseThird">
                            Sunday
                            <span class="font-icon-plus"></span>
                            <span class="font-icon-minus"></span>
                        </a>
                        </div>
                        <div id="collapseThird" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <span style="font-weight: bold;">Breakfast:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Breakfast) %><br/>
                                <span style="font-weight: bold;">Lunch:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Lunch) %><br/>
                                <span style="font-weight: bold;">Snacks:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Snacks) %><br/>
                                <span style="font-weight: bold;">Dinner:</span><br/>
                                <%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Dinner) %><br/>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- End Toggle -->
            </div>
            
        </div>
        <!-- End Accordion/Toggle Section -->
        
        <div class="row">
        	<div class="span12">
            	<hr>
            </div>
        </div>
        
        <!-- Start Alerts/Tabs Section -->
        <div class="row">
        	<!-- Start Alerts -->
            <div class="span6">
            	<h3 class="spec">Alerts</h3>
            
                <!-- <div class="alert alert-standard fade in">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <strong>Oh snap!</strong> Change a few things up and try submitting again. 
                </div> -->
                
                <div class="alert fade in">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <strong>Warning!</strong> No Chole-Bhature On Sunday.
                </div>
                
                <div class="alert alert-error fade in">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <strong>Oh snap!</strong> No food on 23rd Due to OOP Project. 
                </div>

                <div class="alert alert-info fade in">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                	<strong>Heads up!</strong> Project Manager will give the Party..!! 
            	</div>
                
                <div class="alert alert-success fade in">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <strong>Well done!</strong> Team..!
                </div>

                <!-- <div class="alert alert-block alert-danger fade in">
                    <a class="close" data-dismiss="alert" href="#">&times;</a>
                    <h4>Warning!</h4>
                    Best check yo self, you're not...
                </div> -->
                
            </div>
            <!-- End Alerts -->
            
            <!-- Start Tabs -->
            <div class="span6">
            	<h3 class="spec">Mess Manager's Thoughts</h3>
                
            	<div class="tabbable">
                
                    <ul class="nav nav-tabs" id="myTab">
                        <li class="active"><a href="#tab1" data-toggle="tab">Compre</a></li>
                        <li><a href="#tab2" data-toggle="tab">Burgers in NC</a></li>
                        <li><a href="#tab3" data-toggle="tab">Chole Bhature Rush</a></li>
                    </ul>
                 
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1">
                            Use your creativity to put something here.
                        </div>
                        <div class="tab-pane fade in" id="tab2">
                           Use your creativity to put something here.
                        </div>
                        <div class="tab-pane fade in" id="tab3">
                             Use your creativity to put something here.
                        </div>
                    </div>
                            
				</div>
            </div>
            <!-- End Tabs -->
        </div>
        <!-- End Alerts/Tabs Section -->
        
        <div class="row">
        	<div class="span12">
            	<hr>
            </div>	
        </div>
        
        
</div>
<!-- End Shortcodes Section -->
        
<!-- Footer -->

<a id="back-to-top" href="#">
	<i class="font-icon-arrow-simple-up"></i>
</a>
<!-- End Back to Top -->

<!-- Js -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> <!-- jQuery Core -->
<script src="_include/js/bootstrap.min.js"></script> <!-- Bootstrap -->
<script src="_include/js/supersized.3.2.7.min.js"></script> <!-- Slider -->
<script src="_include/js/waypoints.js"></script> <!-- WayPoints -->
<script src="_include/js/waypoints-sticky.js"></script> <!-- Waypoints for Header -->
<script src="_include/js/jquery.isotope.js"></script> <!-- Isotope Filter -->
<script src="_include/js/jquery.fancybox.pack.js"></script> <!-- Fancybox -->
<script src="_include/js/jquery.fancybox-media.js"></script> <!-- Fancybox for Media -->
<script src="_include/js/jquery.tweet.js"></script> <!-- Tweet -->
<script src="_include/js/plugins.js"></script> <!-- Contains: jPreloader, jQuery Easing, jQuery ScrollTo, jQuery One Page Navi -->
<script src="_include/js/main.js"></script> <!-- Default JS -->
<!-- End Js -->

</body>
</html>