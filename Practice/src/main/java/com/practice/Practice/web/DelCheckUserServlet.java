package com.practice.Practice.web;

import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(value = "/delCheckUserServlet")
public class DelCheckUserServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(s);
            service.delUsers(parameterValues);
        }
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
