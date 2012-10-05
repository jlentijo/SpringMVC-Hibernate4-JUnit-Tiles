<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/main.css" rel="stylesheet" type="text/css">
	<title>Login Page</title>
</head>
<body>
	<h2>Login Form with Spring Security 3.1</h2>
	<form method="POST" action="<c:url value="j_spring_security_check"/>" class="form_loggin">
		<table class="form">
			<tbody>
				<tr>
					<td><label>Username:</label></td>
					<td><input type="text" name="j_username" /></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="password" name="j_password" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="error_loggin"><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /></div>
					</td>
				</tr>
				<tr>
					<td><input type="reset" class="button" value="Reset" /></td>
					<td><input type="submit" class="button" value="Loggin" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>