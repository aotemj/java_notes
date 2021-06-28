package com.response.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

// 服务器输出字符到浏览器
@WebServlet(value = "/responseServletDemo3")
public class ResponseServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        解决中文乱码问题
        response.setContentType("text/html;charset=utf-8");
//        获取字符输出流
        PrintWriter pw = response.getWriter();
//        输出数据
        pw.write("服务器来的数据");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
