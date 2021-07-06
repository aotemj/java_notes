package com.example.ServletContextDemo1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet(value = "/servletContentDemo1")
public class ServletContentDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取文件名称
        String filename = request.getParameter("filename");

//        获取 ServletContext 对象
        ServletContext servletContext = request.getServletContext();

//        获取真实路径
        String realPath = servletContext.getRealPath("/WEB-INF/classes/imgs/" + filename);

//        获取 MIMETYPE
        String mimeType = servletContext.getMimeType(realPath);

//        设置请求头
        response.setHeader("content-type", mimeType);

//        设置请求头
        response.setHeader("content-disposition", "attachment;filename=" + filename);

//        读文件
        FileInputStream fileInputStream = new FileInputStream(realPath);

        byte[] bytes = new byte[1024 * 8];

        ServletOutputStream outputStream = response.getOutputStream();
//        文件写入
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) outputStream.write(bytes, 0, len);
    }
}
