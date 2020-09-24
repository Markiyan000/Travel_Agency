<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 21.09.2020
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>LOG IN</title>
</head>

<body>
<div>
    LOGIN
    <form method="POST" action="${pageContext.request.contextPath}/login">
        <h2></h2>
        <div>
            <label>
                <input name="username" type="text" placeholder="Enter username..."/>
            </label><br />
            <label>
                <input name="password" type="password" placeholder="Enter password..."/>
            </label>
            <button type="submit">Log In</button>

        </div>
    </form>
</div>

</body>
</html>
