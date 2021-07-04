package com.servlet.context;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// 获取 MIME type
@WebServlet(value = "/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取servletContext 对象
        ServletContext servletContext = this.getServletContext();

        String filename= "test.jpg";
        String mimeType = servletContext.getMimeType(filename);

        System.out.println(mimeType); // image/jpeg
    }
}
