<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation Bar</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <%@include file="navigation-bar-visitor.jsp"%>
</sec:authorize>
<sec:authorize access="hasAuthority('ROLE_USER') && !hasAuthority('ROLE_ADMIN')">
    <%@include file="navigation-bar-user.jsp"%>
</sec:authorize>
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <%@include file="navigation-bar-admin.jsp"%>
</sec:authorize>
</body>
</html>
