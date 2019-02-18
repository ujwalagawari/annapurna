<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>

<security:authorize access="isAuthenticated()">
	<security:authentication property="principal.username" var="username" />
</security:authorize>
<security:authorize access="!isAuthenticated()">
	<security:authentication property="principal" var="username" />
</security:authorize>
<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px; background-color: red;">

	<img alt="logo"
		src="https://github.com/annapurna-website/Annapurna-Images/blob/master/Restaurant-Images/annap1.jpg?raw=true"
		height="120" width="100%">
	<h3 align="center">
		<a href="${pageContext.request.contextPath}/">Home</a> | 
		<c:if test="${username == 'anonymousUser'}">
			&nbsp; <a href="/login">Log In</a> |
			&nbsp; <a href="/signup">Create an Account</a> 
		</c:if>
		<c:if test="${username != 'anonymousUser'}">
			&nbsp; <a onclick="document.forms['logoutForm'].submit()">Logout</a> |
			&nbsp; <a href="/cart/userProfile">Profile</a> |
			&nbsp; <span>Welcome ${username}</span> 
		</c:if>	
	</h3>
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
	</form>
	
</div>