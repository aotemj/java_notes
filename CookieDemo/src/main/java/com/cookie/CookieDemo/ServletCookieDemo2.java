package com.cookie.CookieDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/servletCookieDemo2")
public class ServletCookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取由服务端发送来的cookie 列表
        Cookie[] cookies = request.getCookies();
        for (Cookie cs : cookies) {
            String name = cs.getName();
            String value = cs.getValue();
            System.out.println("name: " + name + " value: " + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
