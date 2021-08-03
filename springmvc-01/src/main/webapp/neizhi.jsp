<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/2
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--9大内置对象--%>
<%--PageContext  用来拿项目路径   用来存东西   也可以用来做请求转发--%>
<%--Request  用来存东西--%>
<%--Response  用来请求转发和重定向--%>
<%--Session  用来存东西--%>
<%--Application  就是SerlvetContext  用来存东西--%>
<%--config  基本不用--%>
<%--out  就是输出一些东西--%>
<%--page  基本不用--%>
<%--excepetion  异常基本不用--%>
<%
//    pageContext.forward("/helloServlet");  // 请求转发
//    request.getRequestDispatcher("/helloServlet").forward(request,response); // 请求转发第二种写法
//    response.sendRedirect("/springmvc_01/helloServlet"); // 重定向
    pageContext.setAttribute("name","付志远");
    request.setAttribute("name1","付志远");
    session.setAttribute("name2","付志远");
    application.setAttribute("name3","付志远");


    //  取出参数从上往下找
    String name = (String) pageContext.findAttribute("name");  // 只在当前页面有效
    String name1 = (String) request.getAttribute("name1");  // 只在一次请求中有效
    String name2 = (String) session.getAttribute("name2"); // 在一次回话中有效
    String name3 = (String) application.getAttribute("name3"); // 整个应用程序有效
    String name4 = null;
%>
<h1>${name}</h1>
<h1>${name1}</h1>
<h1>${name2}</h1>
<h1>${name3}</h1>
<%--使用el表达式取值空的就是空，使用java取空的就是null--%>
<h1>${name4}</h1>
<h1><%= name4%></h1>
</body>
</html>
