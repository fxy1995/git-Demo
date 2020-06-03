package com.duing.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:03
 * @Version 1.0
 * 第一种在springboot中使用filter-实现servlet包下的filter接口
 * 然后通过配置类把这个过滤器添加入容器中
 */
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是第一个filter我初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是第一个filter我执行了");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("我是第一个filter我销毁了");
    }
}
