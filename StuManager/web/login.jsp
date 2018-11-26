<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form action="LoginServlet" method="post">
<div id="login">
    <p>Login</p>
    <div id="center">
        <input type="text" name="scode" placeholder="Scode" value="${scode }"><br>
        <input type="password" name="password" placeholder="Password" value="${password }">
    </div>
    <c:if test="${not empty error}">
        <div id="error">${error }</div>
    </c:if>
    <div id="bottom">
        <input type="button" value="Forget Password" id="left">
        <input type="submit" value="Login" id="right">
    </div>
</div>
</form>
</body>
</html>
