<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Sign in to Book Manager Application v0.3</title>
</head>
<body>
	<div class="welcomelogin" align="center">
		<h2>Book Manager Application v0.3</h2>
		<s:if
			test="#session.LOGINSUCCESS != null && #session.LOGINSUCCESS == 'false'">
			Username or password incorrect, try again
		</s:if>
		<s:form action="login">
			<s:textfield label="Username" name="username" />
			<s:password label="Password" name="password" />
			<s:submit value="Login" align="center" />
		</s:form>
	</div>
</body>
</html>