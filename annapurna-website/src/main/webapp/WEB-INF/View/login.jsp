<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Annapurna</title>
</head>
 <body class="text-center">
        <div>
            <form action="/login" method="post">
                <h1>Please sign in</h1>
                <div>
               		 <jstl:if test="${param.error}">
                   		 Invalid email and password.
                   	 </jstl:if>	 
                </div>
                <div>
               		 <jstl:if test="${param.logout}">
                   		You have been logged out.
                   	 </jstl:if>	
                </div>
                <label for="inputUserName" >User Name</label>
                <input type="text" name="userName" id="inputUserName" placeholder="User Name" required="" />
                <label for="inputPassword" >Password</label>
                <input type="password" name="password" id="inputPassword" placeholder="Password" required="" />
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
            <form class="form-signin" action="/signup">
                <button class="btn btn-md btn-success btn-block" type="Submit">Signup Here</button>
            </form>
        </div>
</body>
</html>