<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  <body>
  <div id="header">
    <img src="images/logo.ico">
    <ul>
      <li id="hm"><a href="index.jsp" id="home">Home</a></li>
      <c:if test="${not empty student}">
        <li><a href="CourseServlet" target="content">Course</a></li>
      </c:if>
      <c:if test="${not empty student}">
        <li><a href="GradeServlet" target="content">Score</a></li>
      </c:if>
      <c:if test="${not empty student}">
        <li><a href="CourseListServlet?currentPage=1" target="content">Select</a></li>
      </c:if>
      <c:if test="${not empty student}">
        <li><a href="profile.jsp" target="content">Profile</a></li>
      </c:if>
      <c:if test="${not empty student}">
        <li><a href="download.jsp" target="content">Download</a></li>
      </c:if>

      <div id="header_right">
      <c:if test="${empty student}">
        <span><a href="login.jsp" target="content">Login</a></span>
      </c:if>
      <c:if test="${empty student}">
        <span><a href="register.jsp" target="content">Register</a></span>
      </c:if>
        <c:if test="${not empty student}">
          <span><a href="profile.jsp" target="content">${student.name }</a></span>
        </c:if>
        <c:if test="${not empty student}">
          <span><a href="LogoutServlet">Logout</a></span>
        </c:if>
      </div>
    </ul>
  </div>
  <iframe src="content.jsp" name="content"></iframe>
  </body>
</html>
