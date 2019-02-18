<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Annapurna</title>
<style type="text/css">
body{
    /* background-image: url();    */
    background-size:1500px 800px;
    background-color: #d5d6933d;
}
</style>
</head>
<body align="center">
	<jsp:include page="menu.jsp" />
	<h1></h1>
	<%-- ${profile} --%>
		<h2><a href="gettingAccountFromId?profileId=${profile.profileId}">View Details</a></h2>
		<h2><a href="updateAccounts?profileId=${profile.profileId}">Edit Details</a></h2>
		<%-- <h2><a href="updatePassword?profileId=${profile.profileId}">Update Password</a></h2> --%>
	<br>
	<h1 style="color: blue;"><b>eWallet Details</b></h1>
		<h2><a href="AddMoneyLink?profileId=${profile.profileId}">Add Money</a></h2>
		<h2><a href="currentEWalletBalance?profileId=${profile.profileId}">View Current eWallet Balance</a></h2>
		<h2><a href="statement?profileId=${profile.profileId}">View Transactions</a></h2>	
</body>
</html>




