<%@page import="com.deloitte.java.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Details</title>
</head>
<body>

	<form action="EditServlet" method="post">
	Id: <input type="text" name="empid" value=<%=request.getAttribute("empid")%> >
	email: <input type="email" name="email" value=<%=request.getAttribute("email")%>>
	Name: <input type="text" name="name" value=<%=request.getAttribute("name")%> >
	Dept: <input type="text" name="dept" value=<%=request.getAttribute("dept")%> >
	Salary: <input type="text" name="salary" value=<%=request.getAttribute("salary")%> >
	
	<input type="submit" value="Submit">
	</form>
	

</body>
</html>