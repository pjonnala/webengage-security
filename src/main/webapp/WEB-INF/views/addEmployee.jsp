<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/jqueryui.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/uielements.css"/>"/> 	
	<script src="<c:url value="/static/resources/jscript/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/static/resources/jscript/jquery-ui.js"/>"></script>
	<script src="<c:url value="/static/resources/jscript/webengage.js"/>"></script>
</head>
<body>

 <div id="mainContainer" >
 <h3>Add Employee</h3>
	<form:form commandName="newEmployee" action="addUser" >
			<td><p style="color:green;font-size=2em">${newEmpSuccessMsg}</p></td>
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
			  <td><form:input path="email" size="30"/>@webengage.com
		  </tr>
		  <tr>
		  	  <td><form:label path="workPhone">Work Phone:</form:label></td>
			  <td><form:input path="workPhone" size="30"/></td> 
			  <td><form:label path="homePhone">Home Phone:</form:label></td>
			  <td><form:input path="homePhone" size="30"/></td> 			
		
		 </table>
		 <input type="submit" value="Add" />
          <input type="reset" value="Reset" class="cancel" />
          <input type="button" value="Back to search" onclick="loadHomePage()" />
          <form:errors path="name" cssClass="errorblock" element="div"/>
       <td><p style="color: red">${error}</p></td>
 </form:form>
  		
 </div>
</body>
</html>