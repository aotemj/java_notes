package com.Session.SessionDemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/sessionServletDemo1")
public class SessionServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        System.out.println("httpSession: "+httpSession);
//         使用cookie 保存 session ，解决服务器不关闭，客户端关闭重启后的session 不一样问题
        Cookie cookie = new Cookie("JSESSIONID",httpSession.getId());
//         设置超时时间
        cookie.setMaxAge(60*60);
//
        response.addCookie(cookie);
        System.out.println("request invoke");
        httpSession.setAttribute("msg","hello1");

    }
}
