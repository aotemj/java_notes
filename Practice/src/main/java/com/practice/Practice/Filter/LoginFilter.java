package com.practice.Practice.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(value = "/*")
@WebFilter(value = "/test")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        String requestURI = request1.getRequestURI();
//        System.out.println("loginFilter触发");
        if (
                requestURI.contains("login.jsp") ||
                        requestURI.contains("loginServlet") ||
                        requestURI.contains("/css/") ||
                        requestURI.contains("/js/") ||
                        requestURI.contains("checkCodeServlet")
        ) {
            chain.doFilter(request, response);
        } else {
            Object user = request1.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                request1.setAttribute("login_msg", "请登录");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
