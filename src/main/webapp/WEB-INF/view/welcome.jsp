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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/welcome.css">
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
