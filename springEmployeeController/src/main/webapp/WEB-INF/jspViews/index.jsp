<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<title>Employee Management System</title>
<body >
<div class="home-container" style="display:flex;align-items:center;flex-direction:column;font-family:verdana" >
<h1>Employee Management System</h1>

<br>
<br>

<form method ="POST" action="validateUser" >
<label for="name" ></label>
Name: <input type="text" id = "name" name ="uname">
<label for="password" ></label>
<br>
<br>
Password: <input type="password" id = "password" name ="password">
<br>
<br>
<button style="color:white;background-color:#3b5998;margin-left:6rem;border-radius:0.2rem" type="submit">Login</button>
</form>
<a href="registerUser">Don't Have a Account? Create one.</a>
</div>


</body>
</html>
