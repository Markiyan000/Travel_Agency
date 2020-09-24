<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 21.09.2020
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        div {
            display: flex;
            flex-direction: column;
        }
    </style>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="user">
        <form:input type="text" path="firstName" placeholder="First name..." />
        <form:input type="text" path="lastName" placeholder="Last name..." />
        <form:input type="number" path="age" placeholder="Age..." />
        <form:input type="text" path="email" placeholder="Email..." />
        <form:input type="text" path="phone" placeholder="Phone..." />
        <form:input type="text" path="username" placeholder="Username..." />
        <form:input type="password" path="password" placeholder="Password..." />
        <button type="submit">Sign Up</button>
    </form:form>
    <a href="${pageContext.request.contextPath}/">Back</a>
</div>
</body>
</html>
