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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign-up.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            background-color: #022B5A;
        }
    </style>
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

<!-- FORM-->
<div class="container">
    <div class="card">
        <div class="card-body">
            <form:form method="post" action="${pageContext.request.contextPath}/hotels" modelAttribute="hotel">

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="name"
                                    placeholder="Enter name..."  path="name"/>
                        <form:errors path="name" cssClass="error__message"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="country" class="col-sm-2 col-form-label">Country</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="country"
                                    placeholder="Enter country..." path="country" />
                        <form:errors path="country.name" cssClass="error__message"/>
                    </div>
                </div>

                <div class=" form-group row">
                    <label for="city" class="col-sm-2 col-form-label">City</label>
                    <div class="col-sm-7">
                        <form:input type="text" class="form-control" name="city"
                                    placeholder="Enter city..." path="city" />
                        <form:errors path="city" cssClass="error__message"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="description" class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-7">
                        <form:textarea type="text" class="form-control" name="description"
                                    placeholder="Enter description..." path="description" />
                        <form:errors path="description" cssClass="error__message"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="stars" class="col-sm-2 col-form-label">Stars</label>
                    <div class="col-sm-7">
                        <form:input type="number" class="form-control" name="stars"
                                    placeholder="Enter stars..." path="stars" />
                        <form:errors path="stars" cssClass="error__message"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="photo" class="col-sm-2 col-form-label">Photo</label>
                    <div class="col-sm-7">
                        <form:input type="file" class="form-control" name="photo"
                                    path="photo" />
                        <form:errors path="photo" cssClass="error__message"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Save Hotel</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
