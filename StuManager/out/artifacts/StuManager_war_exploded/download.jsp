<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/25
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/download.css">
</head>
<body>
<div id="download">
    <p>点击即可下载</p>
    <ul>
        <li><a href="DownloadServlet?filename=sort.docx">sort.docx</a></li>
        <li><a href="DownloadServlet?filename=IO.png">IO流.png</a></li>
        <li><a href="DownloadServlet?filename=javaEE.PNG">javaEE工作室学习路线图.PNG</a></li>
        <li><a href="DownloadServlet?filename=Web.doc">Web前端开发规范手册.doc</a></li>
        <li>......</li>
    </ul>
</div>
</body>
</html>
