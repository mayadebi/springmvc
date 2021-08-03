
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 获取项目路径--%>
<form action="${pageContext.request.contextPath}/BiaodanServlet" method="post">
    用户名:<input type="text" name="username"><br/>
    密码:<input type="password" name="password"><br/>
    爱好:
    <input type="checkbox" name="aihao" value="吃"/>吃
    <input type="checkbox" name="aihao" value="喝"/>喝
    <input type="checkbox" name="aihao" value="玩"/>玩
    <input type="checkbox" name="aihao" value="乐"/>乐
    <input type="submit" value="提交">
</form>
</body>
</html>
