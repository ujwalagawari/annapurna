<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px; background-color: red;">

	<img alt="logo"
		src="https://github.com/annapurna-website/Annapurna-Images/blob/master/Restaurant-Images/annap1.jpg?raw=true"
		height="120" width="100%">
	<h3 align="center">
		<a href="${pageContext.request.contextPath}/">Home</a> | &nbsp; <a
			onclick="document.forms['logoutForm'].submit()">Logout</a>
			<form action="signup">
				<input type="submit" name="signup" value="signup">
			</form>
	</h3>
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
	</form>
	
</div>