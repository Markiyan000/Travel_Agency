<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 28.09.2020
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navigation Bar</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <%@include file="navigation-bar-visitor.jsp"%>
</sec:authorize>
<sec:authorize access="hasAuthority('ROLE_USER')">
    <%@include file="navigation-bar-user.jsp"%>
</sec:authorize>
<sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <%@include file="navigation-bar-admin.jsp"%>
</sec:authorize>
</body>
</html>
