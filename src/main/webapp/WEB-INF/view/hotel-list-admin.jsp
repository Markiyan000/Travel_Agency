<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 28.09.2020
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel List Admin</title>
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
            <th>Name</th>
            <th>City</th>
            <th>Description</th>
            <th>Country</th>
            <th>Delete</th>
            <th>Add Room</th>
        </tr>
        <c:forEach items="${hotels}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.name}</td>
                <td>${hotel.city}</td>
                <td>${hotel.description}</td>
                <td>${hotel.country.name}</td>
                <td><button type="button" onclick="sendDeleteRequest('hotels', ${hotel.id})">Delete</button></td>
                <td><a href="/rooms/${hotel.id}/form">Add Room</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sendDeleteUserRequest.js"></script>
</body>
</html>
