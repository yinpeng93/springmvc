<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/4 0004
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单个input多文件上传</title>
</head>
<body>
    <form action="/doMultiUpload1" enctype="multipart/form-data" method="post">
        <%--multiple指定属性后该input可以上传多个文件--%>
        <input type="file" name="file" multiple="multiple">
        <button type="submit">提交</button>
    </form>
</body>
</html>
