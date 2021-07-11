<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<%!
    public void updateCookie(HttpServletResponse response) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        Cookie cookie = new Cookie("visittime", time);
        response.addCookie(cookie);
    }
%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    boolean flag = false;
    Cookie[] cookies = request.getCookies();
%>
<%
    for (Cookie ck : cookies) {
        String name = ck.getName();
        System.out.println(name);
        if (name.equals("visittime")) {
            out.write("欢迎回来，您上次访问时间为： " + ck.getValue());
            updateCookie(response);
            flag = true;
            break;
        }
    }

    if (!flag) {
        out.write("您好，欢迎您首次访问");
        updateCookie(response);
    }
%>
</body>
</html>