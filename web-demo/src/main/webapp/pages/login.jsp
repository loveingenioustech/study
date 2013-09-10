<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<%
	String result = (String) session.getAttribute("result");
	if (result != null && result != "") {
		if (result.equals("ok")) {
			out.println("<script>window.alert('Welcome!')</script>");
		} else {
			out.println("<script>window.alert('Sorry, login failed！')</script>");
		}

		session.invalidate();
	}
%>
<body vLink="#006666" link="#003366" bgColor="#E0F0F8">
	<center>
		<img height="130"
			src="${pageContext.request.contextPath}/images/login.jpg" width="185">

		<form action="${pageContext.request.contextPath}/LogonFormServlet"
			method="post">
			User Name: <input type="text" size="15" name="username"><br>
			Password: <input type="password" size="15" name="pwd"><br>
			Check Code: <input type="text" name="check_code"> <img
				src="${pageContext.request.contextPath}/CheckCodeServlet"><br>
			<!--  	
		Radonm Code: <input type="text" name="radom_code"><img
			src="${pageContext.request.contextPath}/RandomCodeServlet"><br>
		-->
			<input type="submit" value="Login"><br>
		</form>
	</center>
</body>
</html>