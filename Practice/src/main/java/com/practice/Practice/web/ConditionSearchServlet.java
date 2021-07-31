package com.practice.Practice.web;

import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/conditionSearchServlet")
public class ConditionSearchServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        List<User> users = service.searchByCondition(parameterMap);
        for(User user: users){
            System.out.println(user.getName());
        }
//        request.setAttribute("users",users);
//        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
