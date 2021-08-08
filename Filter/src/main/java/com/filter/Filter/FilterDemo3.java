package com.filter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 表示只有通过浏览器直接访问的方式才可以触发当前过滤器
@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("当前filter 被触发，表示当前资源的访问方式为浏览器直接访问了");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
