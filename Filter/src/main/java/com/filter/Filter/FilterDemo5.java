package com.filter.Filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo5 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("当前 Filter 是通过 xml 方式配置的");
        chain.doFilter(request,response); // 放行
    }

}
