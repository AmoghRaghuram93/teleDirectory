<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>search_view_by_name</title>
</head>
<body>
<%@include file="menu.jsp" %>

	<div align="right">
		<a float="right" href="/Directory/"> Home</a>
	</div>
	<div align="center">
		<h2>Details</h2>
		<c:choose>
			<c:when test="${not empty person}">
				<div align="center">

					<table border="1">
						<tr>
							<th>ID</th>
							<th>NAME</th>
							<th>PHONE NUMBER</th>
							<th>SECONDARY PHONE NUMBER</th>

						</tr>
						<c:forEach items="${person}" var="persons">
							<tr>

								<td><c:out value="${persons.id}" /></td>
								<td><c:out value="${persons.name}" /></td>
								<td><c:out value="${persons.phoneno}" /></td>
								<td><c:out value="${persons.secondaryphoneno}" /></td>
							</tr>

						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<%
					out.println("SEARCH UNSUCCESSFUL");
				%>
				<br />
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>