<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<script language="javascript">
	var XMLHttpReq = false;
	// Create XMLHttpRequest Object       
	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) { //Mozilla
			XMLHttpReq = new XMLHttpRequest();
		} else if (window.ActiveXObject) { // IE
			try {
				XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
	}

	// Send request function
	function sendRequest(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("GET", url, true);
		XMLHttpReq.onreadystatechange = processResponse;
		XMLHttpReq.send(null);
	}

	// Handle return info
	function processResponse() {
		if (XMLHttpReq.readyState == 4) {
			if (XMLHttpReq.status == 200) {
				var res = XMLHttpReq.responseXML.getElementsByTagName("res")[0].firstChild.data;
				window.alert(res);
			} else {
				window.alert("Requested page has error!");
			}
		}
	}

	// Validate User
	function userCheck() {
		var username = document.userForm.username.value;
		var pwd = document.userForm.pwd.value;
		var check_code = document.userForm.check_code.value;
		
		if (username == "") {
			window.alert("User Name cannot be empty!");
			document.userForm.username.focus();
			return false;
		} else {
			sendRequest("${pageContext.request.contextPath}/LogonFormServlet?username=" + username + "&pwd=" + pwd + "&check_code=" + check_code);
		}
	}
</script>

<body vLink="#006666" link="#003366" bgColor="#E0F0F8">
	<center>
		<img height="130"
			src="${pageContext.request.contextPath}/images/login.jpg" width="185">

		<form name="userForm"
			action=""
			method="post">
			User Name: <input type="text" size="15" name="username"><br>
			Password: <input type="password" size="15" name="pwd"><br>
			Check Code: <input type="text" name="check_code"> <img
				src="${pageContext.request.contextPath}/CheckCodeServlet"><br>
			<!--  	
		Radonm Code: <input type="text" name="radom_code"><img
			src="${pageContext.request.contextPath}/RandomCodeServlet"><br>
		-->
			<input type="button" value="Login" onclick="userCheck()"><br>
		</form>
	</center>
</body>
</html>