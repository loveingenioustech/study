<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<HTML>
<HEAD>
<TITLE>Shopping Online</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/css/tip.css"
	type=text/css rel=stylesheet>
</HEAD>
<script type="text/javascript">
	var dataDiv;
	var dataTableBody;
	var curElement;

	var XMLHttpReq = false;

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

	function getDetail(element) {
		dataTableBody = document.getElementById("dataBody");
		dataDiv = document.getElementById("popup");
		createXMLHttpRequest();
		curElement = element;
		var url = "${pageContext.request.contextPath}/TipServlet?key=" + escape(element.id);
		XMLHttpReq.open("GET", url, true);
		XMLHttpReq.onreadystatechange = processResponse;
		XMLHttpReq.send(null);
	}

	function processResponse() {
		if (XMLHttpReq.readyState == 4) {
			if (XMLHttpReq.status == 200) {
				setData(XMLHttpReq.responseXML);
			} else {
				window.alert("Page requested has error!");
			}
		}
	}

	function setData(data) {
		clearData();
		setOffsets();
		var content = data.getElementsByTagName("content")[0].firstChild.data;
		var row = createRow(content);
		dataTableBody.appendChild(row);
	}

	function createRow(data) {
		var row, cell, txtNode;
		row = document.createElement("tr");
		cell = document.createElement("td");
		cell.setAttribute("bgcolor", "#FFFAFA");
		cell.setAttribute("border", "0");
		txtNode = document.createTextNode(data);
		cell.appendChild(txtNode);
		row.appendChild(cell);
		return row;
	}

	// Set tip position                
	function setOffsets() {
		dataDiv.style.border = "black 1px solid";
		var top = 0;
		while (curElement) {
			top += curElement["offsetTop"];
			curElement = curElement.offsetParent;
		}
		dataDiv.style.left = 50 + "px";
		dataDiv.style.top = top + "px";
	}

	// Clear
	function clearData() {
		var ind = dataTableBody.childNodes.length;
		for ( var i = ind - 1; i >= 0; i--) {
			dataTableBody.removeChild(dataTableBody.childNodes[i]);
		}
		dataDiv.style.border = "none";
	}
</script>

<BODY leftMargin=0 topMargin=0>
	<TABLE cellSpacing=0 cellPadding=0 width=778 align=center border=0>
		<TBODY>
			<TR>
				<TD height=10></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE height=148 cellSpacing=0 cellPadding=0 width=778 align=center
		border=0>
		<TBODY>
			<TR vAlign=top>
				<TD width=236>
					<TABLE width="375" height="340">
						<!--DWLayoutTable-->
						<TBODY>
							<TR>
								<TD width=348 height=1></TD>
								<TD height="1" width="29"></TD>
							</TR>
							<TR>
								<TD height="13" width="348">
									<TABLE id=AutoNumber1 style="BORDER-COLLAPSE: collapse"
										borderColor=#111111 height=20 cellSpacing=0 cellPadding=0
										width=151
										background=${pageContext.request.contextPath}/images/fu.gif
										border=0>
										<TBODY>
											<TR>
												<TD align=middle width=82><B>精品推荐</B></TD>
												<TD align=middle></TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
								<TD height="13" width="29"></TD>
							</TR>
							<TR>
								<TD vAlign=top height=328 width="348">
									<TABLE cellSpacing=0 cellPadding=0 width="103%" border=0>
										<TBODY>
											<TR>
												<TD width="50%"><IMG id="1"
													onmouseover="getDetail(this);" onmouseout="clearData();"
													src="${pageContext.request.contextPath}/images/IBMT43BB4.jpg"
													vspace=6 border=0></A> <BR></TD>
												<TD width="50%"><BR>商品名称:IBM-T43BB <BR>会员价:2500元
													<BR></TD>
											</TR>
											<TR>
												<TD width="50%"><IMG id="2"
													onmouseover="getDetail(this);" onmouseout="clearData();"
													src="${pageContext.request.contextPath}/images/HPNC4200.jpg"
													vspace=6 border=0></TD>
												<TD width="50%"><BR>商品名称:HP-NC4200 <BR> <BR>会员价:1150元
													<BR></TD>
											</TR>
											<TR>
												<TD width="50%"><IMG id="3"
													onmouseover="getDetail(this);" onmouseout="clearData();"
													src="${pageContext.request.contextPath}/images/SONYA21C.jpg"
													vspace=6 border=0></TD>
												<TD width="50%"><BR>商品名称:SONYA21C<BR> <BR>会员价:3880元
													<BR></TD>
											</TR>
										</TBODY>
									</TABLE>
								</TD>
								<TD height="328" width="29"></TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>

				</TD>
			</TR>
			<TR>
				<TD vAlign=top colSpan=4 height=16 width="776"></TD>
			</TR>
		</TBODY>
	</TABLE>
	<div style="position: absolute;" id="popup">
		<table bgcolor="#FFFAFA" border="0" cellspacing="2" cellpadding="2" />
		<tbody id="dataBody">
		</tbody>
		</table>
	</div>
</BODY>
</HTML>
