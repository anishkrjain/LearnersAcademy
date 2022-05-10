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
		HashMap<Integer,String> subject = (HashMap<Integer,String>)request.getAttribute("subjects");
		for(Integer key : subject.keySet()){
			out.println(key + ".     " + subject.get(key));
			out.println("<BR>");
		}
	%>
</body>
</html>