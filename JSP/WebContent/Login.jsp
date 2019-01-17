<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	<h2>LOGIN</h2><br />
	Please enter the following details:<br><br>
	<form action="AboutYou.jsp" method="POST">
		<label for="user">Username: </label><input type="text" placeholder="USERNAME" name="user" required/><br>
		<label for="pwd">Password: </label><input type="password" placeholder="PASSWORD" name="pwd" required/><br>
		<label for="name">Name: </label><input type="text" placeholder="NAME" name="name" required/> <br>
		<label for="email">Email: </label><input type="email" placeholder="EMAIL" name="email" required/><br>
		<label for="age">Age: </label><input type="number" placeholder="AGE" min ="18" max = "99" name="age" required/><br>
		<input type="submit" name="submit"/>
	</form>
</body>
</html>