<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign-up.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/available-form.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            background-color: #022B5A;;
        }
    </style>
    <title>Booking Form</title>
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

<!-- FORM-->
<div class="container">
    <div class="positive__message">${positive}</div>
    <div class="negative__message">${negative}</div>
    <div class="card">
        <div class="card-body">
            <form:form method="post" action="${pageContext.request.contextPath}/bookings/room/${roomId}" modelAttribute="booking">
                <%@include file="available-form-inner.jsp"%>
                <button type="submit" class="btn btn-primary">Book</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
