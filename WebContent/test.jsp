<%@page import="web.SessionHelper"%>
<%@page import="web.Session"%>
<%@page import="actors.Student"%>
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
		String user = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("session")) {
				Session s = SessionHelper.getSession(c.getValue());
				if (s.designation == 0) {
					user = new Student(s.id).getName();
				}
				break;
			}
		}
		if (user == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<%="Hello, " + user + "!"%>
	<form action="Logout" method="post">
		<input type="submit" value="Log out" />
	</form>
</body>
</html>