<%--
  Created by IntelliJ IDEA.
  User: lovixk
  Date: 2021/7/16
  Time: 7:11 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name", "张三");
    session.setAttribute("age", 18);
    session.setAttribute("name", "李四");
%>
${requestScope.age}
${requestScope.name} <%-- 寻找 requsetScope 域中的name属性--%>
${name} <%--从小范围到大范围依次寻找其中的name属性，如果有，显示并停止寻找--%>
</body>
</html>
