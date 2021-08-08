package com.filter.Filter;

//匹配多个dispatcher

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class FilterDemo6 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("当前Filter 即可以被 浏览器直接访问触发，也可以被转发资源触发");
    }

    @Override
    public void destroy() {

    }
}
