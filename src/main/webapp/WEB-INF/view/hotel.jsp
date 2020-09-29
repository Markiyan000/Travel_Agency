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
            <img class="icon" src="${pageContext.request.contextPath}/resources/icons/city-icon.jpg" width="50" height="50" alt="" />
            <div class="info">${hotel.city}</div>
        </div>
        <div class="hotel__description">
            <img class="icon" src="${pageContext.request.contextPath}/resources/icons/description-icon.jpg" width="50" height="50" alt="" />
            <div class="info">${hotel.description}</div>
        </div>
        <div class="hotel__stars">Stars: ${hotel.stars}</div>
        <a href="/hotels/${hotel.id}/available/form">Find Available Rooms</a>
    </div>
</div>

<div class="rooms">
    <c:forEach items="${rooms}" var="room">
        <div class="room__item">
            <img class="room__photo" src="/resources/images/${room.photo}" alt="">
            <div class="root__item__info">
                <div class="room__item__type">${room.roomType.type}</div>
                <div class="room__item__inner">
                    <img class="icon" src="${pageContext.request.contextPath}/resources/icons/people-icon.jpg" alt="" width="30" height="30"/>
                    <div class="room__item__content">${room.numberOfPeople}</div>
                </div>
                <div class="room__item__inner">
                    <img class="icon" src="${pageContext.request.contextPath}/resources/icons/price-icon.jpg" alt="" width="30" height="30"/>
                    <div class="room__item__content">${room.price}</div>
                </div>
                <div class="room__item__inner">
                    <img class="icon" src="${pageContext.request.contextPath}/resources/icons/description-icon.jpg" alt="" width="30" height="30"/>
                    <div class="room__item__content">${room.description}</div>
                </div>
                <div class="room__item__inner">
                    <img class="icon" src="${pageContext.request.contextPath}/resources/icons/quantity-icon.jpg" alt="" width="30" height="30"/>
                    <div class="room__item__content">${room.quantity}</div>
                </div>
                <div class="links">
                    <a href="/bookings/room/${room.id}/form">Book now!</a>
                    <a href="/bookings/room/${room.id}/available/form">Check availability of room</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
