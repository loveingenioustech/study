<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<center>
		<table>
			<caption>Demo List</caption>
			<tr>
				<td align="left"><a
					href="${pageContext.request.contextPath}/pages/signUp.jsp">SignUp</a></td>
			</tr>
			<tr>
				<td align="left"><a
					href="${pageContext.request.contextPath}/pages/login.jsp">Login</a></td>
			</tr>
			<tr>
				<td align="left"><a
					href="${pageContext.request.contextPath}/CountServlet">Count</a></td>
			</tr>
			<tr>
				<td align="left"><a
					href="${pageContext.request.contextPath}/pages/tip.jsp">Tip</a></td>
			</tr>
			<tr>
				<td align="left"><a
					href="${pageContext.request.contextPath}/pages/menu.jsp">Menu</a></td>
			</tr>			
		</table>
	</center>

</body>
</html>
