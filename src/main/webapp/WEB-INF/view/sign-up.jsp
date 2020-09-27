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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign-up.css">
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

<!-- FORM-->
<div class="container">
    <div class="card">
        <div class="card-body">
            <form:form method="post" action="${pageContext.request.contextPath}/sign-up" modelAttribute="user">

                <div class="form-group row">
                    <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="firstName"
                                    placeholder="Enter first name..."  path="firstName"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="lastName"
                                    placeholder="Enter last name..." path="lastName" />
                    </div>
                </div>

                <div class=" form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="username"
                                    placeholder="Enter username..." path="username" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <form:input type="password" class="form-control" name="password"
                                    placeholder="Enter password..." path="password" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="lastName" class="col-sm-2 col-form-label">Age</label>
                    <div class="col-sm-7">
                        <form:input type="number" class="form-control" name="address"
                                    placeholder="Enter age..." path="age" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="contact" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="contact"
                                    placeholder="Enter email..." path="email" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="contact" class="col-sm-2 col-form-label">Phone Number</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="contact"
                                    placeholder="Enter phone..." path="phone" />
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>