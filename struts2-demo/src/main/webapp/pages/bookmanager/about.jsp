<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
    	<link rel="stylesheet" type="text/css" href="style.css" />
        <title>Book Manager Application</title>
    </head>
    <body>
		<div class="welcome" align="center">
			<h2>About</h2>
			<table width="100%">
				<tr>
					<td>
						<div class='breadcrumb'>	
							<a href="welcome.jsp">Home</a><a href="">&gt; About</a>
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
			<table>
				<tr>
					<th rowspan="2"><img src="booklook.gif"/></th>
					<td>Version Number: <s:property value="versionNumber"/></td>
				</tr>
				<tr>
					<td>Build Number: <s:property value="buildNumber"/></td>
				</tr>
			</table>
			<ul class="d">
			
        	</ul>
        </div>
    </body>
</html>