<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="web.SessionHelper"%>
<%@page import="web.Session"%>
<%@page import="actors.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hello World!</title>
</head>
<body>
	<%
		Session s = null;
		Cookie cookies[] = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("session")) {
				s = SessionHelper.getSession(c.getValue());
				if (s != null)
					break;
			}
		}
		if (s == null) {
			response.sendRedirect("log-in/index.html");
		} else if (s.designation == 0)
			response.sendRedirect("swd/swd.jsp");
		else if (s.designation != 1)
			return;
		else if (s.id == 1)
			response.sendRedirect("mess-manager/mess-manager.jsp");
		else if (s.id == 2)
			response.sendRedirect("mess-convener/mess-convener.jsp");
		else {
			response.sendRedirect("log-in/index.html");
		}
	%>
	Please log in:
	<form action="Login" method="post">
		<input type="hidden" name="redirect" value="test.jsp" /> Name: <input
			type="text" name="user" /> Password: <input type="password"
			name="pass" /> <input type="submit" />
	</form>
</body>
</html>