<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:form action="update" modelAttribute="profile">
        <h1>success</h1>
        <table>
            <tr>
                <th>userName</th>
                <th>fullName</th>
                <th>gender</th>
                <th>dateOfBirth</th>
                <th>phoneNumber</th>
                <th>relationShipStatus</th>
                <th>currentAddress</th>
                <th>permanentAddress</th>
            </tr>
            <jstl:if test="${profile !=null}">
                <tr>
                    <td><c:input path="userName" value="${profile.userName}"/></td>
                    <td><c:input path="fullName" value="${profile.fullName}"/></td>
                    <td><c:input path="gender" value="${profile.gender}" readOnly="readonly"/></td>
                    <td><c:input path="dateOfBirth" value="${profile.dateOfBirth}"/></td>
                    <td><c:input path="phoneNumber" value="${profile.phoneNumber}"/></td>
                    <td><c:input path="relationShipStatus" value="${profile.relationShipStatus}"/></td>
                    <td><c:input path="currentAddress" value="${profile.currentAddress}"/></td>
                    <td><c:input path="permanentAddress" value="${profile.permanentAddress}"/></td>
                </tr>
            </jstl:if>
        </table>
        <input type="submit" value="Submit">
        <input type="reset" value="reset">
        <br>
    </c:form>
</body>
</html>\