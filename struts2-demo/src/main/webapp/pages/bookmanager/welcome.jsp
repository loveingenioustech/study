<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="style.css" />
        <title>Book Manager Application v0.3</title>
    </head>
    <body>
		<div class="welcome" align="center">
			<h2>Book Manager Application v0.3</h2>
			<table width="100%">
				<tr>
					<td>
						<div class='breadcrumb'>	
							<a href="welcome.jsp">Home</a>
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
			<ul class="d">
				<s:if test="#session.USER.usertype == 'admin'">
					<li><a href="addbookscreen.action">Add books</a></li>
					<li><a href="exportascsv.action">Export all books as CSV</a></li>
					<li><a href="exportasxml.action">Export all books as XML</a></li>
				</s:if>
	        	<li><a href="listbooks.action">List books</a></li>
	        	<li><a href="about.action">About</a></li>
        	</ul>
        </div>
    </body>
</html>