package com.practice.Practice.web;

import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/delUserServlet")
public class DelUserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println("id: " + id);
        boolean success = service.delUser(Integer.parseInt(id));
        if (success) {
            request.setAttribute("del_msg", "删除用户成功");
            request.getRequestDispatcher("/userListServlet").forward(request, response);
        } else {
            request.setAttribute("del_msg", "删除用户失败");
        }
    }
}
