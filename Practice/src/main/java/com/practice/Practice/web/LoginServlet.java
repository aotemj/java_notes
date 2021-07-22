package com.practice.Practice.web;

import com.practice.Practice.dao.UserDao;
import com.practice.Practice.dao.impl.UserDaoImpl;
import com.practice.Practice.domain.User;
import com.practice.Practice.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String checkCode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        String checked_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        System.out.println(checkCode);
        System.out.println(checked_server);
        System.out.println();
//        验证码正确
        if (checkCode.equalsIgnoreCase(checked_server)) {
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            System.out.println(username);
            System.out.println(password);
//            验证登录操作
            UserDao userDao = new UserDaoImpl();
            User user = userDao.findUserByUsernameAndPassword(username, password);
            if (user != null) {
//                登录成功
                request.setAttribute("login_msg", username + "欢迎您");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
//                登录失败
                request.setAttribute("login_msg", "用户名密码错误,请稍后重试");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } else {
//        验证码不正确
            request.setAttribute("login_msg", "验证码错误");
//           跳转登录
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
