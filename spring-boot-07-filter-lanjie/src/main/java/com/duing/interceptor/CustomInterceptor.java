package com.duing.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:20
 * @Version 1.0
 * 声明一个自定义的拦截器 实现HandlerInterceptor接口实现接口中的声明周期的三个方法
 * 它也需要添加到容器中交给Spring管理---详情见InterceptorConfig
 * 我们需要加一个@Service注解告诉系统这个类需要管理
 */
@Service
public class CustomInterceptor implements HandlerInterceptor {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       System.out.println("处理之前");
       return true;
    }

   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
       System.out.println("处理之中");
   }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("处理之后");
    }
}
