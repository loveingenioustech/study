<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>List Event</title>
</head>
<body>
	<div class="container">
		<table border="1" cellpadding="5" cellspacing="5">
			<tr>
				<th>Event ID</th>
				<th>Event Title</th>
				<th>Title Pound</th>
				<th>Start Date</th>
			</tr>
			<c:forEach var="event" items="${events}">
				<tr>
					<td>${event.id}</td>
					<td>${event.title}</td>
					<td>${event.titlePound}</td>
					<td>${event.startDate}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><a href="${pageContext.request.contextPath}/pages/CreateEvent.jsp">Add Event</a></td>
			</tr>
		</table>

	</div>


	<%--For displaying Previous link except for the 1st page --%>
	<c:if test="${currentPage != 1}">
		<td><a href="ListEventServlet?page=${currentPage - 1}">Previous</a></td>
	</c:if>

	<%--For displaying Page numbers. The when condition does not display a link for the current page--%>
	<table border="1" cellpadding="5" cellspacing="5">
		<tr>
			<c:forEach begin="1" end="${noOfPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<td>${i}</td>
					</c:when>
					<c:otherwise>
						<td><a href="${pageContext.request.contextPath}/ListEventServlet?page=${i}">${i}</a></td>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tr>
	</table>
	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<td><a href="ListEventServlet?page=${currentPage + 1}">Next</a></td>
	</c:if>


	<!-- JavaScript plugins (requires jQuery) -->
	<script src="js/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>