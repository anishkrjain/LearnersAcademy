<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<% 
		HashMap<Integer,String> student = (HashMap<Integer,String>)request.getAttribute("students");
		for(Integer key : student.keySet()){
			out.println(key + ".     " + student.get(key));
			out.println("<BR>");
		}
	%>
</body>
</html>