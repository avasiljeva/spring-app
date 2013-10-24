<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head><title>Sample Users App</title></head>
<body>
	<c:choose>
    	<c:when test="${not empty users}" >
			<h3>Users</h3>
			<table border="1">
				<c:forEach var="user" items="${users}">
				<tr>
					<td><c:out value="${user.id}"/></td>
					<td><c:out value="${user.firstName}"/></td>					
					<td><c:out value="${user.lastName}"/></td>
					
				</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>No users in a system</h3>
		</c:otherwise>
	</c:choose>
	
	<br/><br/>
	
	<h3>Add a new user</h3>
	<form:form commandName="user" method="POST" action="/my-app/spring/users">
	  First name: <form:input path="firstName" />
	  <form:errors path="firstName" cssStyle="color: red;" /><br/>	
	  Last name: <form:input path="lastName" />
	  <form:errors path="lastName" cssStyle="color: red;" /><br/>
	  <input type="submit" value="Add"/>
	</form:form>
</body>
</html>