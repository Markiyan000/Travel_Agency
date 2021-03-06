<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 22.09.2020
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotels</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/hotel-list.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

<div class="search__form">
    <form class="example" action="${pageContext.request.contextPath}/hotels">
        <label>
            <input type="text" placeholder="Search by country.." name="country" />
        </label>
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>

<!-- HOTELS -->
<div class="hotels">
    <c:forEach items="${hotels}" var="hotel">
        <div class="hotels__item">
            <div class="hotels__item__photo">
                <img class="hotel__photo" src="/resources/images/${hotel.photo}" alt="" />
            </div>
            <div class="hotels__content">
                <div class="hotels__item__name">${hotel.name}</div>
                <div class="hotels__item__country">${hotel.country.name}</div>
                <div class="hotels__item__city">${hotel.city}</div>
                <a class="hotels__item__link" href="/hotels/${hotel.id}">See More Information</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
