<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking Form</title>
</head>
<body>
<div>${message}</div>
<form:form method="post" action="/bookings/room/${roomId}" modelAttribute="booking">
    <form:input type="date" path="arrivalDate" placeholder="Arrival Date..." value = "<fmt:formatDate value='${booking.arrivalDate}' pattern='yyyy-MM-dd' />"/>
    <form:input type="date" path="departureDate" placeholder="Departure Date..." value = "<fmt:formatDate value='${booking.departureDate}' pattern='yyyy-MM-dd' />"/>
    <form:input type="number" path="numberOfRooms" placeholder="Number Of Rooms..." />
    <button type="submit">Book</button>
</form:form>
</body>
</html>
