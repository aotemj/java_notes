package com.response.Response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/responseServletDemo1")
public class ResponseServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //         重定向案例
        // 重定向到  /responseServletDemo2
        System.out.println("重定向案例");
        request.setCharacterEncoding("utf-8");

        response.setStatus(302);
        response.setHeader("location", "/responseServletDemo2");

        response.sendRedirect("/responseServletDemo2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doPost(request, response);
    }
}
