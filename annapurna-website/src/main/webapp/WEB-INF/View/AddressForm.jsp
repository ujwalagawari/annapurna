<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
	    /* background-image: url();    */
	    background-size:1500px 800px;
	    background-color: #d5d6933d;
	}
</style>
</head>
<body>
<jsp:include page="menu.jsp" />
	<form action="/cart/submitAddress">
		<h1>DELIVERY ADDRESS</h1>
		Flat Number: <input type="number" name="houseNumber"><br>
		<br> Street Name: <input type="text" name="streetName"><br>
		<br> City: <input type="text" name="city"><br> <br>
		Pin Code: <input type="number" name="pinCode"><br> <br>
		State: <select name="state">
			<option value="Maharashtra">MAHARASHTRA</option>
			<option value="JAMMU & KASHMIR">JAMMU & KASHMIR</option>
			<option value="RAJASTHAN">RAJASTHAN</option>
		</select><br> <br> Country: <select name="country">
			<option value="INDIA">INDIA</option>
		</select> <br> <input type="submit" value="submit">
	</form>
</body>
</html> --%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#order {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#order td, #order th {
	border: 1px solid #ddd;
	padding: 8px;
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

#order tr:nth-child(even) {
	background-color: #f2f2f2;
}

#order tr:hover {
	background-color: #ddd;
}

#order th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>

	<jsp:include page="menu.jsp" />


	<form action="/cart/submitAddress">
		<table id="order">
			<tr>
			<tr>
				<td colspan="2"><h1>DELIVERY ADDRESS</h1>
				<td>
			</tr>
			<tr>
				<td>Flat Number:</td>
				<td><input type="number" name="houseNumber"></td>
			</tr>
			<tr>
				<td>Street Name:</td>
				<td><input type="text" name="streetName"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Pin Code:</td>
				<td><input type="number" name="pinCode"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><select name="state">
						<option value="Maharashtra">MAHARASHTRA</option>
						<option value="JAMMU & KASHMIR">JAMMU & KASHMIR</option>
						<option value="RAJASTHAN">RAJASTHAN</option>
				</select></td>
			</tr>
			<tr>
			<td>
				Country:
				</td>
				<td><select name="country" >
		
			<option value="INDIA">INDIA</option>
			</select></td></tr>
		<tr ><td colspan="2">
			<input type="submit" class="button" value="submit"></td></tr>
		</table>
	</form>



</body>
</html>