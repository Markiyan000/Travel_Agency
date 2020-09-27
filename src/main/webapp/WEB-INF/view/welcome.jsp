<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 21.09.2020
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>

        /*===== INTRO =====*/
        .intro__inner {
            display: flex;
            flex-direction: column;
            text-align: center;
        }

        .intro__title {
            font-family: 'Open Sans', sans-serif;
            font-size: 60px;
            color: white;
            line-height: 1.1;
            font-weight: bold;
            text-align: center;
            text-transform: capitalize;
            margin-bottom: 30px;
        }

        .intro__subtitle {
            line-height: 1.5;
            font-size: 30px;
            color: white;
            font-weight: 400;
            margin-bottom: 60px;
        }

        .btn {
            width: 100px;
            margin: 0 auto;
            display: inline-block;
            vertical-align: top;
            padding: 14px 40px;
            font-size: 13px;
            color: white;
            font-weight: 600;
            font-family: inherit;
            border: 0;
            text-transform: uppercase;
            text-decoration: none;
            cursor: pointer;
            transition: background-color .1s linear;
        }

        .btn--red {
            background-color: red;
        }

        .btn--red:hover {
            background-color: darkred;
        }

    </style>
</head>
<body>
    <!-- HEADER -->
    <%@include file="navigation-bar.jsp"%>

    <!-- INTRO -->
    <div class="intro">
        <div class="intro__inner">
            <h1 class="intro__title">Your The Best Agency</h1>
            <h2 class="intro__subtitle">Choose us and enjoy your life!</h2>
            <a class="btn btn--red" href="${pageContext.request.contextPath}/hotels">Find Hotels</a>
        </div>
    </div>
</body>
</html>
