<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation Bar Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/navigation-bar.css">
</head>
<body>
<!-- HEADER -->
<header class="header">
    <div class="header__div">
        <div class="logo">TravelAgency</div>
        <nav class="nav">
            <a class="nav__link" href="${pageContext.request.contextPath}/home">Home</a>
            <a class="nav__link" href="/profiles/${pageContext.request.userPrincipal.name}">My Profile</a>
            <a class="nav__link" href="#">About us</a>
            <a class="nav__link" href="#">Contact Us</a>
            <a class="nav__link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
    </div>
</header>
</body>
</html>
