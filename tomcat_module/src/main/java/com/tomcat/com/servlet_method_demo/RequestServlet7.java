package com.tomcat.com.servlet_method_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 测试请求转发
@WebServlet(value = "/RequestServlet7")
public class RequestServlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet7被触发");
        // 存储需要共享的数据
        request.setAttribute("name", "servlet7Name");
        // 转发请求
        request.getRequestDispatcher("RequestServlet8").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
