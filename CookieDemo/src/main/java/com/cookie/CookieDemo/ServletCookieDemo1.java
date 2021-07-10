package com.cookie.CookieDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 客户端会话 cookie 入门
@WebServlet(value = "/servletCookieDemo1")
public class ServletCookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        创建cookie
        Cookie cookie = new Cookie("msg", "new message");
//        返回给客户端
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
