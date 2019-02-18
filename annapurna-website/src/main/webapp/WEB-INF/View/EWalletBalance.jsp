<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annapurna</title>
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
	<br/><br/><br/>
	<h1 align="center">Hi ${profile.name}, Your Current eWallet Balance is ${currentBalance} </h1>
</body>
</html>