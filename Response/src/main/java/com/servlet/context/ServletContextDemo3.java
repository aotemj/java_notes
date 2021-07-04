package com.servlet.context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 获取真实目录
@WebServlet(value = "/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String a = "/WEB-INF/a.txt";
        String realPathA = servletContext.getRealPath(a); ///Users/lovixk/test/javaTest/Response/target/Response-1.0-SNAPSHOT/WEB-INF/a.txt
        System.out.println(realPathA);

        String b = "/b.txt";
        String realPathB = servletContext.getRealPath(b); // /Users/lovixk/test/javaTest/Response/target/Response-1.0-SNAPSHOT/b.txt
        System.out.println(realPathB);
    }
}
