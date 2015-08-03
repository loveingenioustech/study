<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
    <title>My App</title>
    <sj:head jquerytheme="start"/>
    <style>
    	body {
    		font-family: Arial,sans-serif;
    		font-size: 9pt;
    	}
    </style>
</head>
 
<body>
	<h2>Please enter a Name</h2>
 
	<s:form action="your-name" theme="xhtml">
		<s:textfield name="name" label="Enter your Name"/>
		<sj:submit 
			targets="result" 
			effect="highlight" 
			value="Submit" 
			button="true"
		/>
	</s:form>
 
	<h3>AJAX Result</h3>
	<div id="result"></div>
</body>
</html>