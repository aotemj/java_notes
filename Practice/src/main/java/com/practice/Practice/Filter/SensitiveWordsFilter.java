package com.practice.Practice.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    //    敏感词
    private List<String> sensitiveWords = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            //      读取配置文件
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/sensitivewords.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sensitiveWords.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest req = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(request, args);
                    value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                    for (String word : sensitiveWords) {
                        if (value.contains(word)) {
                            value = value.replace(word, "***");
                        }
                    }

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
