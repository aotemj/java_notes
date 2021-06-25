package com.tomcat.com.servlet_method_demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(value = "/RequestServletDemo6")
public class RequestServletDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集，防止中文乱码
        request.setCharacterEncoding("utf-8");
        // 获取单个参数
        //        String username = request.getParameter("username");
        //        System.out.println(username);

        // 获取参数数组
//        String[] hobbies = request.getParameterValues("hobby");
//
//        for (String hobby : hobbies) {
//            System.out.println(hobby.toString());
//        }

        // 获取所有参数名称，并根据名称获取对应的value值
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            String[] parameterValues = request.getParameterValues(name);
//            for (String parameterValue : parameterValues) {
//                System.out.println(parameterValue);
//            }
//        }

//         获取参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String str : strings) {
            System.out.println(str);
            String[] values = parameterMap.get(str);
            for (String value : values) {
                System.out.println(value);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
        //        String username = request.getParameter("username");
        //        System.out.println(username);
    }
}
