<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign-up.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user-list.css">
    <style>
        .user__profile {
            margin-top: 50px;
        }

        .user__inner {
            display: flex;
            flex-direction: column;
            margin: 0 auto;
            width: 30%;
        }

        .user__content {
            margin-top: 20px;
            font-size: 20px;
            font-family: 'Open Sans', sans-serif;
        }
    </style>
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>
<div class="user__profile">
    <div class="user__inner">
        <div class="user__content">First Name: ${user.firstName}</div>
        <div class="user__content">Last Name: ${user.lastName}</div>
        <div class="user__content">Age: ${user.age}</div>
        <div class="user__content">Email: ${user.email}</div>
        <div class="user__content">Phone: ${user.phone}</div>
        <div class="user__content">Username: ${user.username}</div>
    </div>
</div>
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
    </div>
</body>
</html>
