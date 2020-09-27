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
        body {
            background-color: #022B5A;
        }

        /*===== HEADER =====*/

        .header {
            width: 100%;
            height: 15%;
        }

        .header__div {
            padding: 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid white;
            margin-left: 20px;
        }

        .nav {
            display: flex;
            font-size: 18px;
            font-weight: bold;
            text-transform: capitalize;
        }

        .nav__link {
            margin-left: 50px;
            color: white;
            text-decoration: none;
            opacity: 0.75;
            transition: opacity .1s linear;
        }

        .nav__link:hover {
            opacity: 1;
        }

        .logo {
            font-family: 'Open Sans', sans-serif;
            font-size: 30px;
            color: black;
        }

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
    <header class="header">
        <div class="header__div">
            <div class="logo">TravelAgency</div>
            <nav class="nav">
                <a class="nav__link" href="${pageContext.request.contextPath}/">Home</a>
                <a class="nav__link" href="${pageContext.request.contextPath}/login">Sign In</a>
                <a class="nav__link" href="#">About us</a>
                <a class="nav__link" href="#">Contact Us</a>
            </nav>
        </div>
    </header>

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
