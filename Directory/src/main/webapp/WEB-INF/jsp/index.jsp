<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>
<body>
    <%@include file="menu.jsp" %>
    <br>
    <c:if test="${not empty person}">
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
    </c:if>
    <c:if test="${empty person}">
        <div align="center">No records present</div>
    </c:if>
    <div align="right"></div>
</body>
</html>