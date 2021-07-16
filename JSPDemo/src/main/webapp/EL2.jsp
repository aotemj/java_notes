<%@ page import="com.JSPDemo.User" %>
<%@ page import="java.util.*" %>
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
<%--     获取 JavaBean--%>
<%
    User u = new User();
    u.setName("张三");
    u.setAge(18);
    u.setBirthday(new Date());

    request.setAttribute("u", u);
%>
<br>
<%-- list 声明 --%>
<%
    List list = new ArrayList();
    list.add(1);
    list.add(2);
    request.setAttribute("list", list);
%>

<%-- map 对象声明 --%>
<%
    Map map = new HashMap();
    map.put("a", 1123);
    map.put("b", 567);
    request.setAttribute("map", map);
%>
${u.name}
${u.age}
${u.birthday}
<br>

<%-- 获取 list--%>
<h4> List 对象获取</h4>

${list}
${list[0]}

<%-- map 对象获取 --%>
<h4> Map 对象获取</h4>

${map.a}
${map.b}

<h4> Empty 运算符</h4>
<%-- Empty 判断--%>

${empty list}
${empty map}
${not empty list}
${empty list[0]}
</body>
</html>
