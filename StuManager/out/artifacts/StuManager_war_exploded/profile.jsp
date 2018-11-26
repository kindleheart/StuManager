<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile</title>
    <link rel="stylesheet" type="text/css" href="css/profile.css">
</head>
<div id="profile">
    <div id="top">
        <img src="images/head01.jpg" id="head">
        <div id="right">
            <div id="right-top">
                <span id="name">${student.name}</span>
                <a href="update.jsp"><img src="./images/update.png" id="update"><br></a>
            </div>
            <div id="right-bottom">
                <span id="scode">jxnu-(#${student.scode})</span>
            </div>
        </div>
    </div>

    <div id="bm">
        <div id="bm-left">
            <ul>
                <li>School:</li>
                <li>Age:</li>
                <li>QQ:</li>
                <li>Email:</li>
                <li>Introduction:</li>
            </ul>
        </div>
        <div id="bm-right">
            <ul>
                <li>${student.school}</li>
                <li>${student.age}</li>
                <li>${student.QQ}</li>
                <li>${student.email}</li>
                <li>${student.introduction}</li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
