<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<style>
  * {
    margin: 0;
    padding: 0;
    font-family: sans-serif;
  }

  a {
    text-decoration: none;
    color: white;
    font-family: sans-serif;
  }

  a:hover {
    color: yellow;
  }
</style>
<head>
  <meta charset="ISO-8859-1">
  <title>Home</title>
  <%@ page isELIgnored="false" %>
</head>
<body>
  <div style="color: white; padding: 1rem; display: flex; align-items: center; justify-content: space-between; background-color: #3b5998">
    <h3>Welcome,<c:out value="${username}"></c:out> </h3>

    <h3>Employee Management System</h3>
    <a href="logout">Logout</a>
  </div>
  <h3 style="text-align:center;font-size:medium;margin-top:1rem"  ><c:out value="${message}"></c:out></h3>
  <h2 style="text-align:center;margin-top:1rem">Our Employees</h2>
  <div style=" display:flex;justify-content:center; margin-top: 2rem;">
  
    <table border=1  >
      <tr>
        <th style="padding:0.2rem">Employee Id</th>
        <th style="padding:0.2rem">Employee Name</th>
        <th style="padding:0.2rem">Salary</th>
        <th style="padding:0.2rem">Action1</th>
        <th style="padding:0.2rem">Action2</th>
      </tr>
      <c:forEach var="employee" items="${empList}">
        <tr>
        
          <td style="padding:0.2rem">${employee.emp_id}</td>
          <td style="padding:0.2rem">${employee.name}</td>
          <td style="padding:0.2rem">${employee.salary}</td>
          <td><a style="padding:0.2rem; color:red" href="delete-employee?id=${employee.emp_id}">Delete</a>
        </td>
        <td><a style="padding:0.2rem; color:blue" href="update-employee?id=${employee.emp_id}">Update</a>
        </td>
        </tr>
      </c:forEach>
      
    </table>
   
  </div>
  <br>
  <br>
 <div class="employee-add" style="display:flex;justify-content:center;;font-family:arial">
 <a href="add-employee" style="color:green">Add new Employee</a>
 </div>
   
</body>
</html>
