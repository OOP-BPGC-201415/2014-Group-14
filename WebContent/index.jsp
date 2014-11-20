<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@page import="web.SessionHelper"%>
<%@page import="web.Session"%>
<%@page import="actors.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hello World!</title>
</head>
<body>
<%
String user = null;
Cookie cookies[] = request.getCookies();
for (Cookie c : cookies) {
    if (c.getName().equals("session")) {
    	Session s = SessionHelper.getSession(c.getValue());
    	if (s == null) continue;
        user = new Student(s.id).getName();
        break;
    }
}
if (user != null) {
    response.sendRedirect("test.jsp");
}
%>
Please log in:
<form action="Login" method="post">
<input type="hidden" name="redirect" value="test.jsp"/>
Name: <input type="text" name="user"/>
Password: <input type="password" name="pass"/>
<input type="submit"/>
</form>
</body>
</html>