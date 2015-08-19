<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Edit</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/jqueryui.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/uielements.css"/>"/> 	
	<script src="<c:url value="/static/resources/jscript/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/static/resources/jscript/jquery-ui.js"/>"></script>
	<script src="<c:url value="/static/resources/jscript/webengage.js"/>"></script>
</head>
<body>

 <div id="mainContainer" >
 <h3>Edit Employee</h3>
	<form:form commandName="updateEmployee" action="updateUser" >
			<form:hidden path="empId" />
			<td><p style="color:green;font-size=2em">${updateEmpMsg}</p></td>
		 <table> 
		  <tr>
    		  	<td><form:label path="name">Name:</form:label></td>
       		    <td><form:input path="name" size="30"/></td>
			  	<td><form:label path="title">Title:</form:label></td>
			  	<td><form:input path="title" size="30"/>
		  </tr>
		
		  <tr>
		  	  <td><form:label path="location">Location:</form:label></td>
			  <td><form:input path="location" size="30"/></td> 
			  <td><form:label path="email">Email:</form:label> </td>
			  <td><form:input path="email" size="30"/>
		  </tr>
		  <tr>
		  	  <td><form:label path="workPhone">Work Phone:</form:label></td>
			  <td><form:input path="workPhone" size="30"/></td> 
			  <td><form:label path="homePhone">Home Phone:</form:label></td>
			  <td><form:input path="homePhone" size="30"/></td> 			
		
		 </table>
		 <table cellpadding=10>
		 	<tr>
		 		<td ><input type="submit" value="Update" /></td>
		 		<td><input type="reset" value="Reset" class="cancel" /></td>
		 		<td><input type="button" value="Back to search" onclick="loadHomePage()" /></td>
		 		<td><input type="button" value="Delete" onClick="deleteUser()"/></td>		 		
		 	</tr>
		 
		 </table>
		 
          
      
          
          		
          <form:errors path="name" cssClass="errorblock" element="div"/>
       <td><p style="color: red">${error}</p></td>
 </form:form>
  		
 </div>
</body>
</html>