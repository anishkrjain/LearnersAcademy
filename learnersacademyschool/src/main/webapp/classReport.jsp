<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body style="background-color: #F1F1F1;">
<h2>CLASS REPORT</h2>
<table>
<tr>
<th>
<table style="border: 1px solid;">
<tr style="border: 1px solid;">
<th style="border: 1px solid;">Teacher</th>
<th style="border: 1px solid;">Subject</th>
</tr>
<%
	ResultSet rs1 = (ResultSet)request.getAttribute("table1");
	while(rs1.next()){
		%>
		<tr>
		<td style="border: 1px solid;"><%=rs1.getString("Teacher") %></td>
		<td style="border: 1px solid;"><%=rs1.getString("Subject") %></td>
		</tr>
		<%
	}
%>
</table>
</th>
<th>
<table style="border: 1px solid;">
<tr style="border: 1px solid;">
<th style="border: 1px solid;">Students</th>
</tr>
<%
	ResultSet rs2 = (ResultSet)request.getAttribute("table2");
	while(rs2.next()){
		%>
		<tr>
		<td style="border: 1px solid;"><%=rs2.getString("Student") %></td>
		</tr>
		<%
	}
%>
</table>
</th>
</tr>
</table>

</body>
</html>