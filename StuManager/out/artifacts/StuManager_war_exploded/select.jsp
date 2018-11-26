<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/27
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>select</title>
    <link rel="stylesheet" type="text/css" href="css/select.css">
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/select.js"></script>
</head>
<body>
<div id="select">
    <p id="p">选课界面</p>
    <c:if test="${not empty searchError}">
        <div id="error">${searchError}</div>
    </c:if>
    <table>
        <tr>
            <td colspan="10">
                <form action="SearchCourseServlet" method="post">
                    按课程号查询：<input type="text" name="number">
                    &nbsp&nbsp&nbsp&nbsp
                    按课程名查询：<input type="text" name="cname">
                    &nbsp&nbsp&nbsp&nbsp
                    <input type="submit" value="查询">
                </form>
            </td>
        </tr>
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
        <c:forEach var="course" items="${pageBean.list}">
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
                <td><a href="#" number="${course.number }" class="choose">选择</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="10">
                第${pageBean.currentPage } / ${pageBean.totalPage } &nbsp&nbsp
                每页显示${ pageBean.pageSize }条 &nbsp&nbsp
                总的记录数${pageBean.totalSize } &nbsp&nbsp
                <c:forEach var="i" begin="1" end="${pageBean.totalPage }">
                    <c:if test="${i == pageBean.currentPage }">
                        ${i }
                    </c:if>
                    <c:if test="${i != pageBean.currentPage }">
                        <a href="CourseListServlet?currentPage=${i }">${i }</a>
                    </c:if>
                </c:forEach> &nbsp&nbsp
                <c:if test="${pageBean.currentPage != 1 }">
                    <a href="CourseListServlet?currentPage=1">首页</a> |
                    <a href="CourseListServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
                </c:if>
                &nbsp&nbsp
                <c:if test="${pageBean.currentPage != pageBean.totalPage }">
                    <a href="CourseListServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> |
                    <a href="CourseListServlet?currentPage=${pageBean.totalPage }">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
