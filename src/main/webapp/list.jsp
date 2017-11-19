<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>    
<%@ page import="com.google.appengine.api.datastore.Entity" %>  
<%@ page import="com.google.appengine.api.datastore.Link" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			<title>List</title>
		</head>
		
	<body>
	 <h1>List</h1>
	  <table>
<% 
	  List<Entity> entityList = (List<Entity>)request.getAttribute("list");

	  if (entityList != null && !entityList.isEmpty()){
		
		for (int i = 0; i < entityList.size(); i++){
			
			Entity entity = entityList.get(i);
%>			
		<tr>
			<td> <%= ((String)entity.getProperty("name")) %> - </td>
			<td> <a href = <%=((Link)entity.getProperty("url")) %>> <%= ((Link)entity.getProperty("url"))  %> - </td>
			<td> <%= ((String)entity.getProperty("category")) %> </td>
			
		</tr>
<%
		}
		
	}
	else {
	
%>		
		<tr><td> There are no items to display </td></tr>
<%
	}
%>
</table>
<table>
		<tr><td><a href="index.html">Main Page</a></td></tr>
</table>


</body>
</html>