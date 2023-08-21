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
.input{
border-radius:0.5rem;
}
</style>
<head>

<meta charset="ISO-8859-1">
<title>Add new Employee</title>

</head>
<body>
<h3 style="text-align:center;font-family:arial">Add New Employee</h3>
<div class = "employee-form">

<form:form action="register-employee" modelAttribute="employee" method="post">
	
	<label for ="name">Name</label>
    <form:input path ="name" id ="name" placeholder="e.g ram"></form:input>
   <form:errors style="color:red" path="name"/>
    <br>
    <br>
    <label for ="salary">Salary</label>
    <form:input path ="salary" id ="salary" placeholder="e.g 81000" value=""></form:input>
    <form:errors style="color:red" path="salary"/>
    <br>
    <br>
    <button type="submit" style="color:white;background-color:#3b5998;margin:auto;border-radius:0.2rem">Submit</button>
</form:form>
</div>

</body>
</html>