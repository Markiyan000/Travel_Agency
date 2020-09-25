<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel</title>
    <style>
        .rooms {
            display: flex;
        }
        .room__item {
            margin-left: 30px;
        }
    </style>
</head>
<body>
<img src="${hotel.photo}" alt="hotel photo"/>
<h3>${hotel.name}</h3>
<h3>${hotel.country.name}</h3>
<h3>${hotel.city}</h3>
<h3>${hotel.description}</h3>
<h3>${hotel.stars}</h3>
<div class="rooms">
    <c:forEach items="${rooms}" var="room">
        <div class="room__item">
            <img src="${room.photo}" alt="image">
            <h4 class="room__item__type">${room.roomType.type}</h4>
            <div class="room__item__quantity">${room.quantity}</div>
            <div class="room__item__people">${room.numberOfPeople}</div>
            <div class="room__item__price">${room.price}</div>
            <div class="room__item__description">${room.description}</div>
            <a href="/bookings/room/${room.id}/form">Book now!</a>
        </div>
    </c:forEach>
</div>
<a href="${pageContext.request.contextPath}/rooms/${hotel.id}/form">Add Room</a>
</body>
</html>
