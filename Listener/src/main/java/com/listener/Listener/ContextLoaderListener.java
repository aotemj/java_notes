package com.listener.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        1. 获取资源文件
        ServletContext servletContext = sce.getServletContext();
//        2. 加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
//        3. 获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
//        4. 加载进内存
        try {
            FileInputStream fileInputStream = new FileInputStream(realPath);
            System.out.println(fileInputStream);
            System.out.println("ServletContext 对象被创建了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
