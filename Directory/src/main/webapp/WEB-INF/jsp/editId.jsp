<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>search_view</title>
</head>
<body>
<%@include file="menu.jsp" %>

<div align="right">
         <a float="right" href="/Directory/">
       Home</a>
    </div>
<div align="center">
<h2> Details of User ID: ${person.id}</h2>
<c:choose>
   <c:when test="${person.id>0}">  
      <table border = "1">
       <tr>
           <th></th>
           <th>Name</th>
           <th>Phone Number</th>
           <th>Secondary Phone Number</th>
       </tr>
               <tr>

                  <td>Edit Values</td>
<form method="POST" action="/Directory/editRequest">
<input type="hidden" name="id" value="${person.id}">
                  <td><input type="text" value="${person.name}" name="username"></td>
                                     
                  <td><input type="text" value="${person.phoneno}" name="phone"></td>
                   <td><input type="text" value="${person.secondaryphoneno}" name="secondaryphone"></td>
                  
                  <td><input type="submit" name="submit"/></td>
</form>
                  </tr>
             
   </table>
   </c:when>    
  <c:otherwise>
      <%out.println("EDIT UNSUCCESSFUL ID DOES NOT EXIST"); %>
       <br />
   </c:otherwise>
</c:choose>  
</div>
</body>
</html>