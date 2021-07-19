<%@ page import="java.util.ArrayList" %>
<%@ page import="com.JSPDemo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lovixk
  Date: 2021/7/19
  Time: 10:33 下午
  To change this template use File | Settings | File Templates.
  需求：在 request 域中有一个存有User 对象的List 集合,
  需要使用 jstl+el 将list 集合数据展示到jsp页面的表格table中
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTLPractice</title>
</head>
<body>

<%
    List list = new ArrayList<User>();
    User user1 = new User();
    user1.setName("张三");
    user1.setAge(20);
    user1.setBirthday(new Date());
    list.add(user1);

    User user2 = new User();
    user2.setName("李四");
    user2.setAge(18);
    user2.setBirthday(new Date());
    list.add(user2);
    request.setAttribute("list", list);
%>

<c:forEach var="user" items="${requestScope.list}">
    姓名：${user.name} 年龄：${user.age} 出生日期：${user.birthday} <br>
</c:forEach>

</body>
</html>
