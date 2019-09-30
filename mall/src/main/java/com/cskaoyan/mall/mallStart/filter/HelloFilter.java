package com.cskaoyan.mall.mallStart.filter;

import javax.servlet.*;
import java.io.IOException;

public class HelloFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("beforeFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("afterFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
