<%@page import="web.*"%>
<%@page import="actors.*"%>
<%@page import="backend.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<%
		MessManager user = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("session")) {
				Session s = SessionHelper.getSession(c.getValue());
				if (s == null) continue;
				if (s.designation == 1 && s.id == 1) {
					user = new MessManager();
	                break;
				}
			}
		}
		if (user == null) {
			response.sendRedirect("log-in/index.html");
		}
	%>
	<%="Hello, " + (user != null ? user.name : "") + "!"%>
	<form action="Logout" method="post">
		<input type="submit" value="Log out" />
	</form>
	<br>
	Complaints:
	<% ArrayList<backend.Complaint> complaints = backend.Complaint.getComplaints(); %>
	<table border="1">
	   <thead>
	   <tr><td><center>From</center></td><td><center>Complaint</center></td></tr>
	   </thead>
	   <%
	   for (backend.Complaint c : complaints) {
		   %>
		   <tr><td><%= c.getFrom() %></td><td><%= c.getText() %></td></tr>
		   <%
	   }
	   %>
	</table>
</body>
</html>