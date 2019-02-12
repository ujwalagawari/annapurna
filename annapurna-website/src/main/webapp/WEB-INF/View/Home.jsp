<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	padding: 5px;
	height: 80px;
	width: 1100px;
	font-size: 20px;
	text-align: center;
	font-family: inherit;
}

th, td {
	padding: 1px;
	background-color: lightgray;
}
</style>
</head>
<body>
<jsp:include page="menu.jsp" />
<%-- ${list} --%>
<div>
	<div>
		<form action="search">
			Search : <input name="search"> 
			<input type="submit" value="Search">
		</form>	
	</div>
	<table>
		<tr>
			<th>Restaurant Name</th>
			<th>Address</th>
		</tr>
		
		<core:forEach var="restaurant" items="${list}">
			<tr>
				<td><a href="/foodItems?restaurantId=${restaurant.restaurantId}">${restaurant.name}</a></td>
				<td>${restaurant.address}</td>
			</tr>
		</core:forEach>
	</table>
</div>

</body>
</html>