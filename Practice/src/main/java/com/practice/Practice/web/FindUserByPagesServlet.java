package com.practice.Practice.web;

import com.practice.Practice.domain.PageBean;
import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;
import com.practice.Practice.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * 分页查询
 */
@WebServlet(value = "/findUserByPagesServlet")
public class FindUserByPagesServlet extends HttpServlet {
    UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        接受请求参数 currentPage, rows
//        当前页码
         String currentPage = request.getParameter("currentPage") ;
        Map<String, String[]> parameterMap = request.getParameterMap();

        //调用Service查询PageBean
        PageBean<User> pb = service.getUserByPages(currentPage,parameterMap);

        //将PageBean 存入 request
        request.setAttribute("pageBean", pb);
        //转发list.jsp 展示
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
