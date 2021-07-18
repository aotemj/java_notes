<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: lovixk
  Date: 2021/7/18
  Time: 9:54 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>
</head>
<body>
<%
    request.setAttribute("str", "abc");

    Map map = new HashMap();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    request.setAttribute("map", map);
%>
<c:forEach var="s" items="${str}">
    ${s} 1<br>2
</c:forEach>

<c:forEach var="item" items="${map}">
    ${item}
</c:forEach>
</body>
</html>
