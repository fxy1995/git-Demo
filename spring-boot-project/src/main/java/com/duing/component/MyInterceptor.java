package com.duing.component;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 付雪缘
 * @Date 2020/6/4 16:44
 * @Version 1.0
 */
//自定义拦截器--配置完之后还需要写一个配置类把自定义拦截器添加到拦截器的注册中心让Spring管理-详情看InterceptorConfig
//@Component
public class MyInterceptor {//implements HandlerInterceptor {
//    //我们在处理之前进行拦截处理
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object handler) throws Exception {
//        //判断当前是否登录
//        Object user = request.getSession().getAttribute("loginUser");
//        if (user != null) {//说明获取到了session,登录成功了
//            System.out.println("放行");
//            return true;//返回true就是放行，false为拦截
//        }
//         request.getRequestDispatcher("/login").forward(request,response);
//        System.out.println("拦截了");
//            return false;
//}

//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        return false;
//    }
//
//
//
//    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    public  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }
}
