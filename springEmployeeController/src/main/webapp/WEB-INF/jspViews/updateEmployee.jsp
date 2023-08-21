<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
*{
background-color:#D0D0D0;
}
.employee-form{
display:flex;
align-items:center;
justify-content:center;
font-family:verdana;

flex-direction:column;

text-align:center;
margin:auto;
margin-top:3rem;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
 <%@ page isELIgnored="false" %>
</head>
<body>

<h3 style="text-align:center;font-family:arial">Update Employee</h3>
<div class = "employee-form">

<form:form action="updateEmployee" modelAttribute="employee" method="post">
	 <label for="name">Name:</label>
    <form:input path ="name" id ="name"  value="${employee.name}"></form:input>
    <form:errors style="color:red" path="name" />
    <br>
    <br>
     <label for="salary">Salary:</label>
    <form:input path ="salary" id ="salary"  value="${employee.salary}"></form:input>
    <form:errors style="color:red" path="salary"/>
    <br>
    <br>
    <button type="submit" style="color:white;background-color:#3b5998;margin-left:4.0rem;margin-bottom:1rem;border-radius:0.2rem">Submit</button>
</form:form>
</div>
</body>
</html>