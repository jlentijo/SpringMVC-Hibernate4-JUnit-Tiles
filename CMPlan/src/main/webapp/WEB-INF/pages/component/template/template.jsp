<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<link href="/CMPlan/css/main.css" rel="stylesheet" type="text/css"/>
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
	<div class="body">
		<div class="header"><tiles:insertAttribute name="header"/></div>
		<div class="page"><tiles:insertAttribute name="page"/></div>
		<div class="footer"><tiles:insertAttribute name="footer"/></div>
	</div>
</body>
</html>