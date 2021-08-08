package com.filter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*") // *: 通配符, 表示所有的资源在被访问的时候都会经过当前过滤器
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter 被执行了");
//         放行操作
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
