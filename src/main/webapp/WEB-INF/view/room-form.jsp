<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 24.09.2020
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room Form</title>
</head>
<body>
<form:form method="post" action="/rooms/${hotelId}" modelAttribute="room">
    <form:select path="roomType">
        <form:option value="APARTMENT" selected="APARTMENT" />
        <form:option value="BALCONY" />
        <form:option value="BDR" />
        <form:option value="BUSINESS" />
        <form:option value="CONNECTED_ROOMS" />
        <form:option value="DE LUXE" />
        <form:option value="FAMILY ROOM" />
    </form:select>
    <form:input type="number" path="numberOfPeople" placeholder="Number of people..." />
    <form:input type="number" path="price" placeholder="Price..." />
    <form:textarea type="text" path="description" placeholder="Description..." />
    <form:input type="file" path="photo" />
    <button type="submit">Save</button>
</form:form>
</body>
</html>
