<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: manjitshakya
  Date: 15/11/2021
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Students</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>

<h1>Students</h1>

<c:if test="${requestScope.errorMsg != null}">
    <h2>${requestScope.errorMsg}</h2>
</c:if>
<c:if test="${requestScope.errorMsg == null}">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>ContactNo</th>
            <th>Address</th>
            <th>DOB</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${requestScope.students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.contactNo}</td>
                <td>${student.address}</td>
                <td>${student.dob}</td>
                <td>${student.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
