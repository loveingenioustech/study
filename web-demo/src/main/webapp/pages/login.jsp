<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LogonFormServlet" method="post">
		User Name:<input type="text" name="username"><br>
		Password:<input type="password" name="pwd"><br> Check
		Code:<input type="text" name="check_code"> <img
			src="${pageContext.request.contextPath}/CheckCodeServlet"><br>
		<input type="submit" value="Login"><br>
	</form>
</body>
</html>