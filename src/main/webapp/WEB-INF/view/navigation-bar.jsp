<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 27.09.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation Bar</title>
    <style>
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
</body>
</html>
