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

                <div class="form-group row">
                    <label for="arrivalDate" class="col-sm-2 col-form-label">Arrival Date</label>
                    <div class="col-sm-7">
                        <form:input type="date" class="form-control" name="arrivalDate"
                                    placeholder="Choose arrival date..."  path="arrivalDate"/>
                        <form:errors path="arrivalDate" cssClass="error__message"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="departureDate" class="col-sm-2 col-form-label">Departure Date</label>
                    <div class="col-sm-7">
                        <form:input type="date" class="form-control" name="arrivalDate"
                                    placeholder="Choose departure date..."  path="departureDate"/>
                        <form:errors path="departureDate" cssClass="error__message"/>
                    </div>
                </div>

                <div class=" form-group row">
                    <label for="numberOfRooms" class="col-sm-2 col-form-label">Number Of Rooms</label>
                    <div class="col-sm-7">
                        <form:input type="number" class="form-control" name="numberOfRooms"
                                    placeholder="Enter number of rooms..." path="numberOfRooms" />
                        <form:errors path="numberOfRooms" cssClass="error__message"/>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Book</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
