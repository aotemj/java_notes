package com.UserLoginDemo.servlet;

import com.UserLoginDemo.dao.UserDao;
import com.UserLoginDemo.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        System.out.println(username);
//        System.out.println(password);


        User loginUser = new User();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao ud = new UserDao();

        User user = ud.login(loginUser);

        if (user == null) {
            System.out.println("登录失败");
            request.getRequestDispatcher("/failServlet").forward(request, response);
        } else {
            System.out.println("登录成功");
            request.setAttribute("user", loginUser);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        }
    }
}
