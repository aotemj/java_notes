package com.practice.Practice.web;

import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 调用 UserService完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();
//        2. 将 List 存入 request 域
        request.setAttribute("users", users);
//        3. 转发到 list.jsp
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
