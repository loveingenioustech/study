<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/menu.css"
	type=text/css rel=stylesheet>
</head>
<script language="javascript">
	var XMLHttpReq;
	var currentSort;

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
				updateMenu();
			} else {
				alert("Error Request!");
			}
		}
	}

	function updateMenu() {
		var res = XMLHttpReq.responseXML.getElementsByTagName("res")
		var subMenu = "";
		for ( var i = 0; i < res.length; i++) {
			subMenu = subMenu + "&nbsp;&nbsp;" + res[i].firstChild.data
					+ "<br>";
		}
		currentSort.innerHTML = subMenu;
	}

	function showSubMenu(obj) {
		currentSort = document.getElementById(obj);
		currentSort.parentNode.style.display = "";
		sendRequest("${pageContext.request.contextPath}/MenuServlet?sort="
				+ obj);
	}
</script>

<table
	style="BORDER-COLLAPSE: collapse borderColor=#111111 cellSpacing=0 cellPadding=0 width=200 bgColor=#f5efe7 border=0">
	<TR>
		<TD align="center" height=4><IMG height=4
			src="${pageContext.request.contextPath}/images/promo_list_top.gif" width="100%" border=0></TD>
	</TR>
	<TR>
		<TD align="center" bgColor=#dbc2b0 height=19><B>笔记本品牌</B></TD>
	</TR>
	<tr>
		<td height="20"><a onClick="showSubMenu('IBM')">IBM</a></td>
	</tr>
	<tr style="display: none">
		<td height="20" id="IBM"></td>
	</tr>
	<tr>
		<td height="20"><a onClick="showSubMenu('SONY')">SONY</a></td>
	</tr>
	<tr style="display: none">
		<td id="SONY" height="20"></td>
	</tr>
</table>
</html>