package com.response.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/responseServletDemo2")
public class ResponseServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        System.out.println("重定向目标页面");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("sendRedirect 当前页面是由 /responseServletDemo1重定向过来的");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
