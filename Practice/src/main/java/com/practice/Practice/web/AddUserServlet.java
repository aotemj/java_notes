package com.practice.Practice.web;


import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            User user = new User();
            BeanUtils.populate(user, parameterMap);
            UserService service = new UserServiceImpl();
            boolean success = service.addUser(user);
            if (success) {
                request.setAttribute("addUserMsg", "添加用户成功");
                request.getRequestDispatcher("/userListServlet").forward(request, response);
            } else {
                request.setAttribute("addUserMsg", "添加用户失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
