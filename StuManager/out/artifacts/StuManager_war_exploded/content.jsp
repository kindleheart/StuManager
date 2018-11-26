<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty student}">
    <h1>尊敬的${student.name},欢迎您</h1>
</c:if>
<c:if test="${empty student}">
    <h1>please login first...</h1>
</c:if>
</body>
</html>
