<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
</head>
<body>
<form action="RegisterServlet" method="post">
    <div id="register">
        <p>Register</p>
        <div id="center">
            <div id="left">
                <input type="text" name="scode" placeholder="*Scode" id="scode"><br>
                <input type="password" name="password" placeholder="*Password"><br>
                <input type="password" name="repassword" placeholder="*Repeat Password"><br>
                <input type="text" name="name" placeholder="*Username"><br>
                <input type="text" name="age" placeholder="Age"><br>
                <input type="text" name="qq" placeholder="QQ"><br>
                <input type="text" name="email" placeholder="Email"><br>
                <input type="text" name="captcha" placeholder="Captcha"><br>
                <img id="captcha" src="CaptchaServlet">
            </div>
            <div id="right">
                <textarea name="introduction"  placeholder="Your brief introduction"></textarea>
            </div>
        </div>
        <c:if test="${not empty registerError}" >
            <div id="error">${registerError }</div>
        </c:if>
       <div id="bottom">
           <input id="sub" type="submit" value="Register">
       </div>
    </div>
</form>
</body>
</html>
