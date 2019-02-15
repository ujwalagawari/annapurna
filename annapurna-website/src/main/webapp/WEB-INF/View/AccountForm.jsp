<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
</head>
<body>
<form action="createAccount"><br><br>
<h1>SignUp Form</h1>
profileImage:<input type="text" name="profileImage"><br><br>

name:<input type="text" name="name"><br><br>
UserName:<input type="text" name="userName"><br><br>
Password:<input type="password" name="password"><br><br>
dateOfBirth:<input type="text" name="dateOfBirth"><br><br>
area:<input type="text" name="address.area"><br><br>
city:<input type="text" name="address.city"><br><br>
state:<input type="text" name="address.state"><br><br>
country:<input type="text" name="address.country"><br><br>
pincode:<input type="text" name="address.pincode"><br><br>
emailId:<input type="email" name="emailId"><br><br>
phoneNumber:<input type="text" name="phoneNumber"><br><br>

gender:<br><br>

<input type="radio" name="gender" value="male" checked> Male<br>
<input type="radio" name="gender" value="female"> Female<br>
<input type="radio" name="gender" value="other"> Other<br>

<input type="submit" name="submit" value="submit">
</form>
</body>
</html>




