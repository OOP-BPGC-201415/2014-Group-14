<%@page import="web.*"%>
<%@page import="actors.*"%>
<%@page import="backend.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE HTML>
<!--
	Astral by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Mess Manager</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
	<link rel="stylesheet" href="css/style-noscript.css" />
	<link rel="stylesheet"
		href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">


</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>
<%
	Session user = null;
	Cookie cookies[] = request.getCookies();
	for (Cookie c : cookies) {
		if (c.getName().equals("session")) {
			Session s = SessionHelper.getSession(c.getValue());
			if (s == null)
				continue;
			if (s.designation == 1 && s.id == 1) {
				user = s;
				break;
			}
		}
	}
	if (user == null) {
		response.sendRedirect("../index.jsp");
		return;
	}
	MessManager mm = new MessManager();
	String action = request.getParameter("action");
	if (action != null && action.equals("menu")) {
		Menu m = Menu.getMenu();
		m.setMenuFor(Menu.Day.values()[Integer.parseInt(request
				.getParameter("day"))], Menu.Meal.values()[Integer
				.parseInt(request.getParameter("meal"))], request
				.getParameter("menudata"));
	}
%>
<body>

	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav">
			<a href="#me" class="icon fa-home active"><span>Home</span></a> <a
				href="#work" class="icon fa-folder"><span>Complaints</span></a> <a
				href="#contact" class="icon fa-envelope"><span>Set Menu</span></a> <a
				href="../hygienereport/hygienereport.html" class="icon fa-pencil"><span>Hygiene</span></a>
			<a href="../Logout" class="icon fa-sign-out"><span>Logout</span></a>
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- Me -->
			<article id="me" class="panel">
				<header>
					<h1><%=mm.name%></h1>
					<p>Mess Manager</p>
				</header>
				<a href="#work" class="jumplink pic"> <span
					class="arrow icon fa-chevron-right"><span>See my work</span></span>
					<img src="images/person.svg" alt="" />
				</a>
			</article>

			<!-- Work -->
			<article id="work" class="panel">
				<header>
					<h2>Complaints</h2>
				</header>
				<section>


					<%
						ArrayList<backend.Complaint> complaints = backend.Complaint
								.getComplaints();
					%>
					<table border="1">
						<thead>
							<tr>
								<td><center>From</center></td>
								<td><center>Complaint</center></td>
							</tr>
						</thead>
						<%
							for (backend.Complaint c : complaints) {
						%>
						<tr>
							<td><center><%=c.getFrom()%></center></td>
							<td><center><%=c.getText()%></center></td>
						</tr>
						<%
							}
						%>
					</table>




				</section>
			</article>

			<!-- Contact -->
			<article id="contact" class="panel">
				<header>
					<h2>Set Menu</h2>
				</header>
				<form action="mess-manager.jsp" method="post" name="menuform"
					id="menuform">
					<input type="hidden" name="action" value="menu" />
					<div>
						<div class="row">
							<div class="6u">
								<select name="day" form="menuform">
									<option value="0">Monday</option>
									<option value="1">Tuesday</option>
									<option value="2">Wednesday</option>
									<option value="3">Thurday</option>
									<option value="4">Friday</option>
									<option value="5">Saturday</option>
									<option value="6">Sunday</option>
								</select>
							</div>
							<div class="6u">
								<select name="meal" form="menuform">
									<option value="0">Breakfast</option>
									<option value="1">Lunch</option>
									<option value="2">Snacks</option>
									<option value="3">Dinner</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="12u">
								<textarea name="menudata" placeholder="Menu" rows="8"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="12u">
								<input type="submit" value="Set Menu" />
							</div>
						</div>
					</div>
				</form>
			</article>


		</div>

		<!-- Footer -->


	</div>

</body>
</html>