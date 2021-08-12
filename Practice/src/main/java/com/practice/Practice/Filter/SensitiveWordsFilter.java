package com.practice.Practice.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest req = (ServletRequest)Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(request, args);
                    value = new String(value.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
                    value = value.replace("笨蛋", "***");
                    return value;
                } else {
                    Object obj = method.invoke(request, args);
                    return obj;
                }
            }
        });

        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {

    }
}
