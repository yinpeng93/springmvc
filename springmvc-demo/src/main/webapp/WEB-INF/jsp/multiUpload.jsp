<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/4 0004
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>
    <form action="/doMultiUpload" enctype="multipart/form-data" method="post">
        <input type="file" name="file1"/>
        <br/>
        <input type="file" name="file2"/>
        <button type="submit">提交</button>
    </form>
</body>
</html>
