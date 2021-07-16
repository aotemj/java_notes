<%@ page import="com.JSPDemo.User" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: lovixk
  Date: 2021/7/16
  Time: 10:29 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User u = new User();
    u.setName("张三");
    u.setAge(18);
    u.setBirthday(new Date());
    request.setAttribute("u",u);
%>
${u.name}
${u.age}
${u.birthday}
</body>
</html>
