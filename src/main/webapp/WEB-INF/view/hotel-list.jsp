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
            margin-top: 50px;
            margin-left: 75px;
            display: flex;
            flex-wrap: wrap;
        }

        .hotels__item {
            width: 300px;
            height: 350px;
            position: relative;
            overflow: hidden;
            border-left: 1px solid white;
            border-right: 1px solid white;
        }

        .hotel__photo {
            width: 300px;
            height: 350px;
        }

        .hotels__content {
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
            opacity: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(232, 69, 69, 0.9);
            position: absolute;
            top: 0;
            left: 0;
            z-index: 2;
            transition: opacity .3s linear;
        }

        .hotels__item:hover .hotels__content {
            opacity: 1;
        }

        .hotels__item__name {
            font-size: 14px;
            font-weight: bold;
            text-transform: uppercase;
            color: #fff;
            margin-bottom: 5px;
        }

        .hotels__item__country, .hotels__item__city {
            font-size: 14px;
            color: #fff;
        }

        .hotels__item__city {
            margin-top: 5px;
        }

        .hotels__item__link {
            margin-top: 10px;
            color: white;
            text-decoration: none;
            opacity: 0.75;
            transition: opacity .1s linear;
        }

        .hotels__item__link:hover {
            opacity: 1;
        }
    </style>
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

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
