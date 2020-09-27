<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 24.09.2020
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign-up.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar-home.jsp"%>

<!-- FORM-->
<div class="container">
    <div class="card">
        <div class="card-body">
            <form:form method="post" action="${pageContext.request.contextPath}/rooms/${hotelId}" modelAttribute="room">

                <div class="form-group row">
                    <label for="roomType" class="col-sm-2 col-form-label">Room Type</label>
                    <div class="col-sm-7">
                        <form:select path="roomType" сlass="form-control">
                            <form:option value="APARTMENT" selected="APARTMENT" />
                            <form:option value="BALCONY" />
                            <form:option value="BDR" />
                            <form:option value="BUSINESS" />
                            <form:option value="CONNECTED_ROOMS" />
                            <form:option value="DE LUXE" />
                            <form:option value="FAMILY ROOM" />
                        </form:select>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="numberOfPeople" class="col-sm-2 col-form-label">Number Of People</label>
                    <div class="col-sm-7">
                        <form:input type="number" class="form-control" name="numberOfPeople"
                                    placeholder="Enter number of people..." path="numberOfPeople" />
                    </div>
                </div>

                <div class=" form-group row">
                    <label for="price" class="col-sm-2 col-form-label">City</label>
                    <div class="col-sm-7">
                        <form:input type="number" class="form-control" name="price"
                                    placeholder="Enter price..." path="price" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="description" class="col-sm-2 col-form-label">Description</label>
                    <div class="col-sm-7">
                        <form:textarea type="text" class="form-control" name="description"
                                       placeholder="Enter description..." path="description" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
                    <div class="col-sm-7">
                        <form:input type="number" class="form-control" name="quantity"
                                    placeholder="Enter quantity..." path="quantity" />
                    </div>
                </div>

                <div class="form-group row">
                    <label for="photo" class="col-sm-2 col-form-label">Photo</label>
                    <div class="col-sm-7">
                        <form:input type="file" class="form-control" name="photo"
                                    path="photo" />
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Save Room</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
