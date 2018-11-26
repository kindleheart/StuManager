<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/25
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/update.css">
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/update.js"></script>
</head>
<body>
<form action="UpdateServlet" method="post">
    <div id="update">
        <p>Update</p>
        <div id="center">
            <div id="left">
                <input type="text" name="scode" placeholder="*${student.scode}" id="scode" disabled><br>
                <input type="password" name="oripassword" placeholder="*Original Password"><br>
                <input type="password" name="newpassword" placeholder="New Password"><br>
                <input type="password" name="repassword" placeholder="Repeat Password"><br>
                <input type="text" name="name" placeholder="Username" value="${student.name}"><br>
                <input type="text" name="age" placeholder="Age" value="${student.age}"><br>
                <input type="text" name="qq" placeholder="QQ" value="${student.QQ}"><br>
                <input type="text" name="email" placeholder="Email" value="${student.email}"><br>
                <input type="text" name="captcha" placeholder="Captcha"><br>
                <img id="captcha" src="CaptchaServlet">
            </div>
            <div id="right">
                <textarea name="introduction"  placeholder="Your brief introduction">${student.introduction}</textarea>
            </div>
        </div>
        <c:if test="${not empty updateError}">
            <div id="error">${updateError }</div>
        </c:if>
        <div id="bottom">
            <input id="sub" type="submit" value="Update">
        </div>
    </div>
</form>
</body>
</html>
