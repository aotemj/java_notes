package com.tomcat.com.servlet_method_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        获取请求方式
        //        String getMethod()
        String method = request.getMethod();
        System.out.println("获取请求方式:method: " + method);
        //        获取虚拟目录（掌握) /day14
        String contextPath = request.getContextPath();
        System.out.println("获取虚拟路径（常用）: contextPath: " + contextPath);
        //        String getContextPath()
        //        获取 Servlet路径
        //        String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println("Servlet路径:getServletPath: " + servletPath);
        //        获取 get方式请求参数
        //        name=zhangsan
        //        String getQueryStrign()
        String queryString = request.getQueryString();
        System.out.println("get方式请求参数: queryString: " + queryString);
        //        获取请求URI（掌握）
        // 	/day14/demo1
        //        String getRequestURI()
        String requestURI = request.getRequestURI();
        System.out.println("获取请求URI(常用) requestURI: " + requestURI);
        //        获取请求URL
        //        http://localhost/day14/demo1
        //        StringBuffer getRequestURL()
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("获取请求URL: requestURL: " + requestURL);
        //        获取协议及版本
        //        HTTP/1.1
        //        String getProtocol()
        String protocol = request.getProtocol();
        System.out.println("获取协议及版本 protocol: " + protocol);
        //        获取客户机的IP地址
        //        String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println("获取客户机的IP地址: remoteAddr: " + remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
