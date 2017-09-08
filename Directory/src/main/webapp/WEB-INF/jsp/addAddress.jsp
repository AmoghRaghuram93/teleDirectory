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
        <h1>User Address Details</h1>
        <br>
        <h3>Enter the address</h3>
        <br>
        <hr>
        <form:form method="post" action="/Directory/addressDetails" modelAttribute="addressDetails">
            <label>House number : </label><form:input type="text" path="houseNo"/><br>
            <label>street :</label><form:input type="text" path="street" /><br>
            <label>locality :</label><form:input type="text" path="locality" /><br>
            <label>city :</label><form:input type="text" path="city" /><br>
            <label>state :</label><form:input type="text" path="state" /><br>
            <label>zipcode :</label><form:input type="text" path="zipcode" /><br>
            <label>Address Type</label><form:select path="addressType">
                        <form:option value="NONE" label="Select" />
                        <form:options items="${addressTypeList}" />
                    </form:select><br>
                    
                    
                Person ID <form:input path="person.id" />   
                Person name <form:input path="person.name" id ="name"/>   
                Person phone num <form:input path="person.phoneno" id="phoneno" />   
            <input type="submit" name="submit" />                
        </form:form>
    </div>
</body>
</html>