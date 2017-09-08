<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>

</head>
<body>
<%@include file="menu.jsp" %>

	<div id="container" align="center">
		<h1>Search User</h1>
		<br>
		<hr>
		<form method="post" action="/Directory/searchId">
				<label>ID : </label><input type="number" name="id" required/><br>
			<input type="submit" name="submit"/>
		</form>
	</div>
</body>
</html>