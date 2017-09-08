<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>search_view</title>
</head>
<body>
<%@include file="menu.jsp" %>

	<div align="center">
		<h2>Details</h2>
		<div align="right">
			<a float="right" href="/Directory/"> Home</a>
		</div>
		<c:choose>
			<c:when test="${not empty person}">
				<table border="1">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Phone number</th>
						<th>SECONDARY PHONE NUMBER</th>
					</tr>
					<tr>

						<td>${person.id}</td>

						<td>${person.name}</td>

						<td>${person.phoneno}</td>
						<td><c:out value="${persons.secondaryphoneno}" /></td>


					</tr>

				</table>
			</c:when>
			<c:otherwise>
				<%out.println("THE ID DOES NOT EXIST"); %>
				<br />
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>