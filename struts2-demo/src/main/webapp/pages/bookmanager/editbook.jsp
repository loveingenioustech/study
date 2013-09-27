<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style.css" />
        <title>Book Manager Application v0.3</title>
	</head>
	<body>
		<div class="welcome" align="left">
			<h2>Book Manager Application v0.3</h2>
			<table width="100%">
				<tr>
					<td>
						<div class='breadcrumb'>	
							<a href="welcome.jsp">Home</a><a href=""> &gt; Edit Book</a>
						</div>
					</td>
					<td>
						<div align="right">
							<s:push value="#session.USER">
								Welcome <s:property value="username"/>  <a href="logout.action">  Logout</a>
							</s:push>
							
						</div>
					</td>
				</tr>
			</table>
			<s:form action="editbook">
				<s:hidden name="book_id"/>
				<s:textfield label="Catalog" name="catalog"/>
				<s:textfield label="Title" name="title"/>
				<s:textfield label="Author" name="author"/>
				<s:textfield label="Copyright" name="copyright"/>
				<s:radio label="Binding" list="bindings" name="binding"/>
				<s:submit value="Update" align="center"/>
			</s:form>
		</div>
	</body>
</html>