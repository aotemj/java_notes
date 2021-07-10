package com.cookie.CookieDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

// 需求：
// 1. 访问一个servlet, 如果是第一次访问，则提示： 您好，欢迎您首次访问
// 2. 如果不是第一次访问，则提示： 欢迎回来，您上次访问时间为： 显示时间字符串
@WebServlet(value = "/servletCookieDemo3")
public class ServletCookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();

        for (Cookie ck : cookies) {
            String name = ck.getName();
            System.out.println(name);
            if (name.equals("visittime")) {
                writer.write("欢迎回来，您上次访问时间为： " + ck.getValue());
                updateCookie(response);
            }
        }
        writer.write("您好，欢迎您首次访问");
        updateCookie(response);

    }
    public void updateCookie (HttpServletResponse response){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        Cookie cookie = new Cookie("visittime", time);
        response.addCookie(cookie);
    }
}
