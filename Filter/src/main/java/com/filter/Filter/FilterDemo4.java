package com.filter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 当前Filter 只有在被资源转发时才会被访问
@WebFilter(value = "/*", dispatcherTypes = DispatcherType.FORWARD)
public class FilterDemo4 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("当前 Filter 只有在 资源被转发访问时才会触发");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
