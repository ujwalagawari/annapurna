<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
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
		<table>
		<tr>
			<th>Food Name</th>
			<th>Price</th>
			<th>Description</th>
			<th></th>
		</tr>
		<core:forEach var="foodItems" items="${restaurant.foodItems}">
			<tr>
				<td>${foodItems.foodName}</td>
				<td>${foodItems.price}</td>
				<td>${foodItems.description}</td>
				<td><a href="/cart/addCart?restaurantName=${restaurant.name}&foodName=${foodItems.foodName}
				&price=${foodItems.price}&quantity=1<%-- &address=${restaurant.address} --%>">Add </a></td>
			</tr>
		</core:forEach>
	</table>
	
</body>
</html>