package com.response.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(value = "/responseServletDemo4")
public class ResponseServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         统一字符集
        response.setContentType("text/html;charset=utf-8");
//         获取字节输出流对象
        ServletOutputStream outputStream = response.getOutputStream();
//         输出数据
        outputStream.write("hello,张三".getBytes(StandardCharsets.UTF_8));
    }
}
