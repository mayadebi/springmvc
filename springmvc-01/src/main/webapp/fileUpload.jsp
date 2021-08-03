<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/2
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--文件上传表单加enctype="multipart/form-data"  必须用post--%>
<form action="${pageContext.request.contextPath}/FileUploadServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="file1">
    <input type="file" name="file2">
    <input type="submit" value="提交">
</form>
</body>
</html>
