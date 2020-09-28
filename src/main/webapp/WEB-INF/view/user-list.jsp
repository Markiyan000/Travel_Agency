<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 28.09.2020
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user-list.css">
</head>
<body>
    <!-- HEADER -->
    <%@include file="navigation-bar-admin.jsp"%>

    <!-- TABLE -->
    <div class="container">
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Username</th>
                <th>Enabled</th>
                <th>Bookings</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${user.username}</td>
                    <td>${user.enabled}</td>
                    <td><a href="/bookings/user/${user.id}">Bookings</a></td>
                    <td><button type="button" onclick="sendDeleteRequest('users', ${user.id})">Delete</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sendDeleteUserRequest.js"></script>
</body>
</html>
