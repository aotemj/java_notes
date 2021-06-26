package com.UserLoginDemo.servlet;

import com.UserLoginDemo.dao.UserDao;
import com.UserLoginDemo.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(username);
        System.out.println(password);
        UserDao ud = new UserDao();
//        UserDao ud = new UserDao();

//        User loginUser = ud.login(user);
//        if (loginUser == null) {
//            System.out.println("登录失败");
//        } else {
//            System.out.println("登录成功");
//        }
    }
}
