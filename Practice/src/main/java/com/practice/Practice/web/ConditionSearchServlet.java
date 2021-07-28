package com.practice.Practice.web;

import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/conditionSearchServlet")
public class ConditionSearchServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");

        List<User> users = service.searchByCondition(name, address, email);
        request.setAttribute("users",users);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
