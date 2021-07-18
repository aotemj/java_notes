<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lovixk
  Date: 2021/7/17
  Time: 10:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 当前 prefix 的值要和 下面使用的 c:if 保持一致， 约定俗成为 c--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="true">
    常量 true
</c:if>

<c:if test="false">
    常量 false, 永远不会显示
</c:if>
<%-- c:if 不存在 else 语句， 如果需要，则需要另外一个 c:if --%>
<%--判断 request 域中的一个list 集合是否为空，如果不为空 则显示遍历集合，如果为空则什么都不显示--%>
<%
    List list = new ArrayList();
    list.add("hello");
    request.setAttribute("list",list);
%>
<c:if test="${not empty list}">
<%--  遍历集合  --%>
    ${requestScope.list}
</c:if>

<%
    request.setAttribute("number",3);
%>
<c:if test="${number %2 == 0}">
    ${requestScope.number} 为偶数
</c:if>¡
<c:if test="${number %2 != 0}">
    ${requestScope.number} 为奇数
</c:if>
</body>
</html>
