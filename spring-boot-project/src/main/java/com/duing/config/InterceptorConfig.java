package com.duing.config;

import com.duing.component.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 付雪缘
 * @Date 2020/6/4 17:00
 * @Version 1.0
 */
//首先这是一个配置类
 //   @Configuration
public class InterceptorConfig {//implements WebMvcConfigurer {
//   @Autowired
//   private MyInterceptor myInterceptor;//自定义拦截器的对象，我们要把这个对象添加到拦截器的注册中里
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(myInterceptor).addPathPatterns("/**")// "/**表示我们要拦截所有请求"
//        .excludePathPatterns("/login","/*.css","/*.js");//表示哪些请求我们不拦截
//    }
}
