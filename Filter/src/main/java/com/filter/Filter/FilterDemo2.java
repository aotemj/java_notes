package com.filter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 目录拦截Filter
 */
@WebFilter("/test/*")
public class FilterDemo2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("test 目录下Filter 被触发");
        chain.doFilter(request, response);// 放行
    }

    @Override
    public void destroy() {

    }
}
