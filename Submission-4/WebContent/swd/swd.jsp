<%@page import="java.text.*"%>
<%@page import="web.SessionHelper"%>
<%@page import="web.Session"%>
<%@page import="actors.Student"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE HTML>
<!--
	Miniport by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>SWD</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
</head>
<body>
	<%
		Student user = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("session")) {
				Session s = SessionHelper.getSession(c.getValue());
				if (s == null)
					continue;
				if (s.designation == 0) {
					user = new Student(s.id);
					break;
				}
			}
		}
		if (user == null) {
			response.sendRedirect("../index.jsp");
		}
		if (request.getParameter("action") != null && request.getParameter("action").equals("leave")) {
			DateFormat df = new SimpleDateFormat("d/M/y h:m a");
            long from = df.parse(request.getParameter("fromdate")).getTime();
            long to = df.parse(request.getParameter("todate")).getTime();
			user.applyForLeave(from, to);
		}
	%>
	<!-- Nav -->
	<nav id="nav">
		<ul class="container">
			<li><a href="#top">SWD</a></li>
			<li><a href="#work">Mess Option</a></li>
			<li><a href="#portfolio">Leave</a></li>
			<li><a href="../Logout">Logout</a></li>
			<!-- <li><a href="#contact">Contact</a></li> -->
		</ul>
	</nav>

	<!-- Home -->
	<div class="wrapper style1 first">
		<article class="container" id="top">
			<div class="row">
				<div class="4u">
					<span class="image fit"><img src="images/bits.png" alt="" /></span>
				</div>
				<div class="8u">
					<header>
						<h1>
							Welcome to <strong>SWD</strong>.
						</h1>
					</header>
					<p>
						This is <strong>SWD</strong>, a site made for the students to
						easily change mess-option and apply for leave.
					</p>
					<a href="#work" class="button big scrolly">Vote For Mess</a>
				</div>
			</div>
		</article>
	</div>

	<!-- Work -->
	<div class="wrapper style2">
		<article id="work">
			<header>
				<h2>Vote For Mess</h2>
				<p>
					for the month of <strong><u>[add next month through
							java]</u></strong>
				</p>
			</header>
			<div class="container">
				<form>
					<input type="radio" name="sex" value="0" checked>A-Mess
					&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						type="radio" name="sex" value="1">C-Mess
					<p>
						<br /> <input type="submit" name="submitmessopt" value="Submit"
							id="submitmessopt">
					</p>
				</form>
			</div>
			<footer>
				<p>Thank you for voting. Saving the work of our randomised
					alloter :p :D</p>
				<!-- <a href="#portfolio" class="button big scrolly">Apply For Leave</a> -->
			</footer>
		</article>
	</div>

	<!-- Portfolio -->
	<div class="wrapper style2">
		<article id="portfolio">
			<header>
				<h2>Going home...?</h2>
				<p>
					Bring back some home-made sweets :p :) <i class="fa fa-angellist"></i>
				</p>
			</header>
			<div class="container" align="center">
				<form action="swd.jsp" method="post" align="center">
				<input type="hidden" name="action" value="leave"/>
					<p>
					<h2>Departure</h2>
					</p>
					<span align="center" style="width: 30%"> <input type="text"
						style="width: 30%" placeholder="DD/MM/YY HH:MM AM/PM"
						name="fromdate">
					</span>
					<p>
					<h2>Arrival</h2>
					</p>
					<span align="center" style="width: 30%"> <input type="text"
						style="width: 30%" placeholder="DD/MM/YY HH:MMAM/PM" name="todate">
					</span><br/><br/>
					<input type="submit" name="leavereq" value="Submit" id="leavereq">
				</form>
			</div>
		</article>
	</div>

	<!-- Contact -->


</body>
</html>