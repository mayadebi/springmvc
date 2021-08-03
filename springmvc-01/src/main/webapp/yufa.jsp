<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--把这个jsp插入  会将俩个页面合二为一 ，变量共享--%>
<%@include file="centent/top.jsp"%>
<%--把这个jsp插入  是拼接页面本质还是三个 ，变量不共享--%>
<jsp:include page="centent/top.jsp"/>
<%--用来显示java的值--%>
<%= new Date()%>
<%--用来写java代码--%>
<%
    System.out.println("aaaaa");
    out.println("aaaaa"); // 可以直接输出到页面
%>
<%
    for (int i=0;i<10;i++){
%>
    <h1>hello word</h1>
<%
    }
%>
<%@include file="centent/bottom.jsp"%>
<jsp:include page="centent/bottom.jsp"/>
</body>
</html>
