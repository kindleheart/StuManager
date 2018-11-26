<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/29
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Grade</title>
    <link rel="stylesheet" type="text/css" href="css/grade.css">
</head>
<body>
<div id="grade">
    <p>课程成绩</p>
    <table>
        <tr>
            <td>课程号</td>
            <td>课程中文名</td>
            <td>课程英文名</td>
            <td>学分</td>
            <td>分数</td>
            <td>班级最高分</td>
            <td>班级平均分</td>
            <td>班级最低分</td>
        </tr>
        <c:forEach var="grade" items="${gradeList}">
            <tr>
                <td>${grade.number}</td>
                <td>${grade.cname}</td>
                <td>${grade.ename}</td>
                <td>${grade.score}</td>
                <td>${grade.grade}</td>
                <td>${grade.top}</td>
                <td>${grade.avg}</td>
                <td>${grade.low}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
