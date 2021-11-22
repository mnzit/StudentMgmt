<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<button>
    <a href="students/create">Create Student</a>
</button>
<h2>${requestScope.message}</h2>
<c:if test="${requestScope.status == true}">
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
