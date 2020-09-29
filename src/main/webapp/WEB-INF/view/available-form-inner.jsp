<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 29.09.2020
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Form Inner</title>
</head>
<body>
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
</body>
</html>
