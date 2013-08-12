<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Hibernate Demo</title>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/CreateEventServlet"
			method="post">
			<table>
				<tr>
					<td>Event Id:</td>
					<td><input type="text" name="eventId" /></td>
				</tr>
				<tr>
					<td>Event Title:</td>
					<td><input type="text" name="eventTitle" /></td>
				</tr>
				<tr>
					<td>Event Title Pound:</td>
					<td><input type="text" name="titlePound" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>