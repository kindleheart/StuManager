<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/27
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>course</title>
    <link rel="stylesheet" type="text/css" href="css/course.css">
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/course.js"></script>
</head>
<body>
<div id="course">
    <p id="p">已选课程</p>
    <c:if test="${not empty success}">
        <div id="success">${success }</div>
    </c:if>
    <table>
        <tr>
            <td>课程号</td>
            <td>课程中文名</td>
            <td>课程英文名</td>
            <td>学分</td>
            <td>周理论学时</td>
            <td>周实验学时</td>
            <td>理论总学时</td>
            <td>实验总学时</td>
            <td>开课情况</td>
            <td>操作</td>
        </tr>
        <c:forEach var="course" items="${courseList}">
            <tr>
                <td>${course.number}</td>
                <td>${course.cname}</td>
                <td>${course.ename}</td>
                <td>${course.score}</td>
                <td>${course.chour}</td>
                <td>${course.lhour}</td>
                <td>${course.tchour}</td>
                <td>${course.tlhour}</td>
                <td>${course.open}</td>
                <td><a href="#" number="${course.number }" class="delete">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
