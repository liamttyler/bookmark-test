<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add</title>
	</head>

	<body>
		<h1>Add</h1>
		
		<form action="add" method="GET">
		  <tr>
				<td>Name: </td>
				<td><input type="text" name="name"></td>
				<td>URL: </td>
				<td><input type="text" name="url"></td>
				<td>Category: </td>
				<td><input type="text" name="category"></td>
		  </tr>
		  
		  <tr>
				<td><input type="Reset" value="Reset"></td>
				<td><input type="Submit" value="Submit"></td>
		  </tr>
		
		<table>
		<tr><td><a href="index.html">Main Page</a></td></tr>
		</table>
		</form>
		
		
		

	</body>
</html>