<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 26.09.2020
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Rooms Form</title>
</head>
<body>
<div id="message"></div>
<label>
    <input type="date" id="arrivalDate"/>
</label>
<label>
    <input type="date" id="departureDate"/>
</label>
<button type="submit" onclick="sendAjaxCall(${roomId})">Check</button>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sendAjaxCall.js"></script>
</body>
</html>
