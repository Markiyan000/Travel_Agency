<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 21.09.2020
  Time: 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h3>Welcome :${user.firstName}</h3>
    <a href="${pageContext.request.contextPath}/admin/home">Management</a>
</body>
</html>
