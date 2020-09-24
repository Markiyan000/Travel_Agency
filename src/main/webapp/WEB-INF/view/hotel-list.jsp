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
    <style>
        .hotels {
            display: flex;
        }
    </style>
</head>
<body>
<div class="hotels">
    <c:forEach items="${hotels}" var="hotel">
        <div class="hotels__item">
            <h4 class="hotels__item__name">${hotel.name}</h4>
            <img src="${hotel.photo}" alt="image">
            <div class="hotels__item__country">${hotel.country.name}</div>
            <div class="hotels__item__city">${hotel.city}</div>
            <div class="hotels__item__stars">${hotel.stars}</div>
            <a href="${pageContext.request.contextPath}/hotels/${hotel.id}">See more information</a>
        </div>
    </c:forEach>
</div>
</body>
</html>
