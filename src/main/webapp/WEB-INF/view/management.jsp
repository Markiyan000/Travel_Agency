<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Portal</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/management.css">
</head>
<body>
<%@include file="navigation-bar.jsp"%>
    <h2>Management Page</h2>
    <div class="links">
        <a class="link__item" href="${pageContext.request.contextPath}/hotels/form">Add Hotel</a>
        <a class="link__item" href="${pageContext.request.contextPath}/users/all">View All Users</a>
        <a class="link__item" href="${pageContext.request.contextPath}/admin/hotels">View All Hotels</a>
    </div>
</body>
</html>
