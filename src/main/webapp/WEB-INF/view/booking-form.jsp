<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 25.09.2020
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking Form</title>
</head>
<body>
<form:form method="post" action="/bookings/room/${roomId}" modelAttribute="booking">
    <form:input type="date" path="arrivalDate" placeholder="Arrival Date..." value = "<fmt:formatDate value='${booking.arrivalDate}' pattern='yyyy-MM-dd' />"/>
    <form:input type="date" path="departureDate" placeholder="Departure Date..." value = "<fmt:formatDate value='${booking.departureDate}' pattern='yyyy-MM-dd' />"/>
    <form:input type="number" path="numberOfRooms" placeholder="Number Of Rooms..." />
    <button type="submit">Book</button>
</form:form>
</body>
</html>
