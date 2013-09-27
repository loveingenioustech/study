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
							<a href="welcome.jsp">Home</a><a href=""> &gt; List Books</a>
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
		
			<table width="100%">
				<tr>
					<s:if test="#session.USER.usertype == 'admin'">
						<th align="center">Actions</th>
					</s:if>
					<th align="center">Catalog</th>
					<th align="center">Title</th>
					<th align="center">Author</th>
					<th align="center">Copyright</th>
					<th align="center">Binding</th>
				</tr>	
		    	<s:iterator value="books" status="rowstatus">
		    		<s:if test="#rowstatus.odd == true">
		    			<tr class="odd">
		    		</s:if>
		    		<s:else>
		    			<tr class="even">
		    		</s:else>
		    			<s:if test="#session.USER.usertype == 'admin'">
		    				<td align="center">
		    					<s:form theme="simple">
		    						<s:hidden name="book_id" />
		    						<s:submit action="editbookscreen" value="Edit"/>
		    						<s:submit action="deletebook" value="Delete"/>
		    					</s:form>
		    				</td>
		    			</s:if>
		    			<td align="center"><s:property value="catalog" /></td>
		    			<td align="center"><s:property value="title" /></td>
	        			<td align="center"><s:property value="author" /></td>
	        			<td align="center"><s:property value="copyright" /></td>
	        			<td align="center"><s:property value="binding" /></td>
		  			</tr>
		  		</s:iterator>
	  		</table>
	  	</div>
	</body>
</html>