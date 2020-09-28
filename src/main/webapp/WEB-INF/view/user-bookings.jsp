<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 28.09.2020
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Bookings</title>
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
            <th>Arrival Date</th>
            <th>Departure Date</th>
            <th>Price</th>
            <th>Number Of Rooms</th>
            <th>Room</th>
        </tr>
        <c:forEach items="${bookings}" var="booking">
            <tr>
                <td>${booking.id}</td>
                <td>${booking.arrivalDate}</td>
                <td>${booking.departureDate}</td>
                <td>${booking.price}</td>
                <td>${booking.numberOfRooms}</td>
                <td>${booking.room.id}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
