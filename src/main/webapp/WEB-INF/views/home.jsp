<%--
  Index page comments go here
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>



<head>
   
	
	
    <title>WebEngage- Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 	<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/jqueryui.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/uielements.css"/>"/> 	
	<script src="<c:url value="/static/resources/jscript/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/static/resources/jscript/jquery-ui.js"/>"></script>
	<script src="<c:url value="/static/resources/jscript/webengage.js"/>"></script>

	

</head>

<body>

<table class="simpletablestyle">
<tr>
<td >
 Welcome Employee Id <p style="color:green;font-size=2em">${welcomeMsg}</p>
</td>
	<td><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></td>
</tr>
</table>
 
  <% if(request.isUserInRole("ROLE_HR")){ %>
 	<button type="button"  name="addBtn"  onClick="loadAddPage()" style="margin-top: 10px;margin-left: 100px;" >Add User</button>
	<%} %>
 <div id="mainContainer" >
 	<h3>Search</h3>
 	<form:form commandName="employeeSearch">
 		<td><p style="color:green;font-size=2em">${deleteUsrMsg}</p></td>
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
			
		
		 </table>
		 <input type="submit" value="Search" />
          <input type="reset" value="Reset" class="cancel" />
          <form:errors path="name" cssClass="errorblock" element="div"/>
       <td><p style="color: red">${error}</p></td>
 </form:form>
 </div>
 <div id="searchResults">
   <h2>Employee Results</h2>
        <c:choose>
            <c:when test="${employees.size()==0}">
                <em>No Search results found for your criteria!</em>
            </c:when>
            <c:otherwise>
                <table id="employeeTable" class="simpletablestyle">
                    <thead>
                        <tr>
                            <th>Emp Id</th>
                            <th>Name</th>
                            <th>Job Title</th>                            
                            <th>Location</th>
                            <th>Email</th>
                            <th>Work Phone</th>
							
                        </tr>
                    </thead>
                    <tbody>
           
                        <c:forEach items="${employees}" var="employee">
                                 <c:url value="displayEditUser" var="displayEditURL">
 						 				<c:param name="empId"   value="${employee.empId}" />
								</c:url>
                            <tr> <% if(request.isUserInRole("ROLE_HR")){ %>
                                	<td><a href="<c:out value="${displayEditURL}"/>">${employee.empId}</a></td>
                                <% }else { %>
                                	<td>${employee.empId}</td>
                                <%} %>
                                	
                                <td>${employee.name}</td>
                                <td>${employee.title}</td>
                                <td>${employee.location}</td>
                                <td>${employee.email}</td>
                                <td>${employee.workPhone}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
         </c:otherwise>
        </c:choose>
 </div>

</body>
</html>
