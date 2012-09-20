<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Index Page CMPlan</title>
</head>
<body>
	<h2>Loggin Form with Spring Security 3.1</h2>
	<form method="POST" action="<c:url value="j_spring_security_check"/>">
		<table>
			<tbody>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="j_username"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="text" name="j_password"/></td>
				</tr>
				<tr>
					<td colspan="2"><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Loggin"/></td>
				</tr>
			</tbody>		
		</table>
	</form>
</body>
</html>