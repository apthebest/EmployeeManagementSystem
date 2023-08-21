<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create an Account</title>
</head>
<body>
<div class="home-container" style="display:flex;align-items:center;flex-direction:column;font-family:verdana" >
<h1>Employee Management System</h1>

<br>
<br>

<form method ="POST" action="createAccount" >
<label for="firstname" ></label>
First Name: <input type="text" id = "firstname" name ="firstname">
<br>
<br>
<label for="lastname" ></label>
Last Name: <input type="text" id = "lastname" name ="lastname">
<br>
<br>
<label for="username" ></label>
User Name: <input type="text" id = "username" name ="uname">
<br>
<br>
<label for="password" ></label>
Password: <input type="password" id = "password" name ="password">
<br>
<br>
<button style="color:white;background-color:#3b5998;margin-left:6rem;border-radius:0.2rem" type="submit">Create your Account</button>
</form>

</div>

</body>
</html>