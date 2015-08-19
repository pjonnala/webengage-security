<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search-Looking for someone. We have answers!!</title>
<script type="text/javascript">
$( document ).ready(function() {
	//applies css for buttons on this page
    $( "button" ).button();
    
});

</script>
</head>
<body>
  
<form>
 <table> 
  <tr>
     
	  <td>Name:</td>
	  <td><form:input path="name"/></td> <form:errors class="invalid" path="name"/>
	  <td>Title: </td>
	  <td><input type="text"  name="title" size="30"/>
  </tr>

  <tr>
  	  <td>Location:</td>
	  <td><input type="text"  name="location" size="30"/></td> 
	  <td>email: </td>
	  <td><input type="text"  name="title" size="30"/>@webengage.com
  </tr>
  <tr>
  	  <td>Work Phone:</td>
	  <td><input type="text"  name="workPhone" size="30"/></td> 
	  <td>Home Phone: </td>
	  <td><input type="text"  name="homePhone" size="30"/>
  </tr>

 </table>

 <button type="button"  name="srchBtn"  onClick="invokeSearch()" >Search</button>
 
 </form>
</body>
</html>