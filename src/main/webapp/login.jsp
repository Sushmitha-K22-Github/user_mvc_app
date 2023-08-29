<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg }</h1>
	<form action="login" method="post">
		<input type="tel" name="phone" placeholder="enter your phone number"><br>
		<input type="password" name="password"
			placeholder="enter your password"><br> <input
			type="submit" value="Login">
	</form>
	<h1>
		<a href="register.jsp">click here to Register</a>
	</h1>
</body>
</html>