<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/3 0003
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h1>上传附件</h1>
    <form action="/doUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <button type="submit">提交</button>
    </form>
</body>
</html>
