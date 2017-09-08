<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add</title>

</head>
<body>
<%@include file="menu.jsp" %>

<div align="right">
         <a float="right" href="/Directory/">
       Home</a>
    </div>
	<div id="container" align="center">
		<h1>User Details</h1>
		<br>
		<h3>Enter the details</h3>
		<br>
		<hr>
		<form:form method="post" action="/Directory/addAddress" modelAttribute="person" name="person" >
			<label>Name : </label><input type="text" name="name" required
				  /><br> <label>Phone :
			</label><input type="text" name="phoneno" required /><br> <input
				type="submit" name="submit" />
				<form:errors path="phoneno"/>
								<form:errors path="name"/>
				
		</form:form>
	</div>
</body>
</html>