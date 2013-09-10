<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<head>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
</head>
<script language="javascript">
	var XMLHttpReq;

	function createXMLHttpRequest() {
		if (window.XMLHttpRequest) {
			XMLHttpReq = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
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

	function sendRequest(url) {
		createXMLHttpRequest();
		XMLHttpReq.open("GET", url, true);
		XMLHttpReq.onreadystatechange = processResponse;
		XMLHttpReq.send(null);
	}

	function processResponse() {
		if (XMLHttpReq.readyState == 4) {
			if (XMLHttpReq.status == 200) {
				var res = XMLHttpReq.responseXML.getElementsByTagName("res")[0].firstChild.data;
				window.alert(res);
			} else {
				window.alert("Error request!");
			}
		}
	}

	function signUp() {
		var username = document.signupForm.username.value;
		var pwd = document.signupForm.pwd.value;
		var pwd2 = document.signupForm.pwd2.value;
		if (username == "") {
			window.alert("User Name cannot be empty!");
			document.signupForm.username.focus();
			return false;
		} else if (pwd != pwd2) {
			window.alert("Different password!");
			document.signupForm.pwd.focus();
			return false;
		} else {
			sendRequest('${pageContext.request.contextPath}/SignUpServlet?username='
					+ username + '&pwd=' + pwd);
		}
	}
</script>

<body vLink="#006666" link="#003366" bgColor="#E0F0F8">
	<img height="211"
		src="${pageContext.request.contextPath}/images/signup.jpg" width="239">

	<form action="" method="post" name="signupForm">
		User Name: <input size="15" name="username">
		<p>
			Password: <input type="password" size="15" name="pwd">
		<p>
			Re-input Password: <input type="password" size="20" name="pwd2">
		<p>
			<input type="button" value="Register" onclick="signUp()">
	</form>