<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Portal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/management.css">
</head>
<body>
<%@include file="navigation-bar.jsp"%>
    <h3>Management Page</h3>
    <div class="links">
        <a href="${pageContext.request.contextPath}/users">View All Users</a>
        <a href="${pageContext.request.contextPath}/admin/hotels">View All Hotels</a>
    </div>
</body>
</html>
