package com.duyi.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 14:26
 * @Version 1.0
 * 实现filter的第二种方式--不推荐---写完之后去config包中配置,把写好的filter添加入容器中
 */
public class FilterDemoTwo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我初始化咯");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我执行咯");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("我销毁咯");
    }
}
