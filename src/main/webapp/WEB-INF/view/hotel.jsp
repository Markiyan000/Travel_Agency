<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/hotel.css">
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>
<div class="container">
    <img class="hotel__photo" src="/resources/images/${hotel.photo}" width="700" height="450" alt=""/>
    <div class="hotel__content">
        <div class="hotel__name">${hotel.name}</div>
        <div class="hotel__country">
            <img class="icon" src="${pageContext.request.contextPath}/resources/icons/country-icon.jpg" width="50" height="50" alt="" />
            <div class="info">${hotel.country.name}</div>
        </div>
        <div class="hotel__city">
            <img class="icon" src="${pageContext.request.contextPath}/resources/icons/country-icon.jpg" width="50" height="50" alt="" />
            <div class="info">${hotel.city}</div>
        </div>
        <div class="hotel__description">
            <img class="icon" src="${pageContext.request.contextPath}/resources/icons/description-icon.jpg" width="50" height="50" alt="" />
            <div class="info">${hotel.description}</div>
        </div>
        <div class="hotel__stars">Stars:   ${hotel.stars}</div>
    </div>
</div>

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
            <a href="/bookings/room/${room.id}/available/form">Check availability of room</a>
        </div>
    </c:forEach>
</div>
<a href="${pageContext.request.contextPath}/rooms/${hotel.id}/form">Add Room</a>
</body>
</html>
