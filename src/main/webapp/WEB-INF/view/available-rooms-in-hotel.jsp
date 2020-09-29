<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 29.09.2020
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Rooms in Hotel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign-up.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/available-form.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            background-color: #022B5A;;
        }
    </style>
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

<!-- FORM-->
<div class="container">
    <div class="card">
        <div class="card-body">
            <form:form method="get" action="${pageContext.request.contextPath}/hotels/${hotelId}/available" modelAttribute="bookingDto">
                <%@include file="available-form-inner.jsp"%>
                <button type="submit" class="btn btn-primary">Find</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
