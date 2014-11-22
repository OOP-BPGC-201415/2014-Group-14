<%@page import="java.util.*"%>
<%@page import="backend.Menu"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<%
Menu m = Menu.getMenu();
%>
<body>
<table rows="7" columns="5">
<thead>
<tr>
<td>Day</td>
<td>Breakfast</td>
<td>Lunch</td>
<td>Snacks</td>
<td>Dinner</td>
</tr>
</thead>
<tr>
<td>Monday</td>
<td><%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Monday, Menu.Meal.Dinner) %></td>
</tr>
<tr>
<td>Tuesday</td>
<td><%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Tuesday, Menu.Meal.Dinner) %></td>
</tr>
<tr>
<td>Wednesday</td>
<td><%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Wednesday, Menu.Meal.Dinner) %></td>
</tr>
<tr>
<td>Thursday</td>
<td><%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Thursday, Menu.Meal.Dinner) %></td>
</tr>
<tr>
<td>Friday</td>
<td><%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Friday, Menu.Meal.Dinner) %></td>
</tr>
<tr>
<td>Saturday</td>
<td><%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Saturday, Menu.Meal.Dinner) %></td>
</tr>
<tr>
<td>Sunday</td>
<td><%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Breakfast) %></td>
<td><%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Lunch) %></td>
<td><%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Snacks) %></td>
<td><%= m.getMenuFor(Menu.Day.Sunday, Menu.Meal.Dinner) %></td>
</tr>
</table>
</body>
</html>