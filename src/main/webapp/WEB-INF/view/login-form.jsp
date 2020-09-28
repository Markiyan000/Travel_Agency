<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login-form.css">
    <style>
        body {
            background-color: #022B5A;
        }
    </style>
</head>
<body>
<!-- HEADER -->
<%@include file="navigation-bar.jsp"%>

<!-- FORM -->
<div class="wrapper fadeInDown">
    <div id="formContent">

        <form method="post" action="${pageContext.request.contextPath}/login">
            <label for="login"></label><input type="text" id="login" class="fadeIn second" name="username" placeholder="Enter username..." />
            <label for="password"></label><input type="password" id="password" class="fadeIn third" name="password" placeholder="Enter password..." />
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

        <div id="formFooter">
            <a class="underlineHover" href="${pageContext.request.contextPath}/sign-up">Don't have an account yet? Sign Up</a>
        </div>
    </div>
</div>
</body>
</html>