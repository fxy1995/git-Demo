package com.duing.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:12
 * @Version 1.0
 * 使用filter的第二种方式--通过@WebFilter(配置filter name 和 pattern)
 * 设置完成后需要在启动类上加@ServletComponetSpan---让系统扫描servlet组件
 */
@WebFilter(filterName = "filterTwo" ,urlPatterns = {"/*"})
public class CustomFilterTwo  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("第二个filter启动了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第二个filter执行了");
       filterChain. doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("第二个filter销毁了");
    }
}
