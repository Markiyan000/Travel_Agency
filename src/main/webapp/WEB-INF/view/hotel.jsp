<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel</title>
</head>
<body>
<h3>${hotel.name}</h3>
<a href="${pageContext.request.contextPath}/rooms/${hotel.id}/form">Add Room</a>
</body>
</html>
