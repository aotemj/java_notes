package com.tomcat.com.servlet_method_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 测试请求转发
@WebServlet(value = "/RequestServlet8")
public class RequestServlet8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("触发ServletDemo8...");
        // 获取从 servlet7中传递过来的数据
        Object name = request.getAttribute("name");
        System.out.println("由Servlet7 传递的数据(name)： " + name);
        request.removeAttribute("name");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
