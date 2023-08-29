<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${u!=null }">
			<h2>
				<a href="viewUser.jsp">View User</a>
			</h2>
			<h2>
				<a href="update.jsp">Update User</a>
			</h2>
			<h2>
				<a href="delete?id=${u.getId() }">Delete User</a>
			</h2>
			<h2>
				<a href="logout">Logout</a>
			</h2>
		</c:when>
		<c:otherwise>
			<%
			response.sendRedirect("login.jsp");
			%>
		</c:otherwise>
	</c:choose>
</body>
</html>