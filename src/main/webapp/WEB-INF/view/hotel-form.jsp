<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 22.09.2020
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel Form</title>
    <style>
        form {
            display: block;
        }
    </style>
</head>
<body>
<form:form method="post" action="/hotels" modelAttribute="hotel">
    <form:input type="text" path="name" placeholder="Name..." />
    <form:input type="text" path="country" placeholder="Country..." />
    <form:input type="text" path="city" placeholder="City..." />
    <form:textarea type="text" path="description" placeholder="Description..." />
    <form:input type="number" path="stars" placeholder="Stars..." />
    <form:input type="file" path="photo" placeholder="Photo..." />
    <button type="submit">Save</button>
</form:form>
</body>
</html>
