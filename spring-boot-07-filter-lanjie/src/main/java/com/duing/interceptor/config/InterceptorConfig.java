package com.duing.interceptor.config;

import com.duing.interceptor.CustomInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:28
 * @Version 1.0
 * 需要重写 addInterceptors方法
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    //因为我们拦截器已经通过@Service交给了Spring管理所以我们直接通过@Autowired进行注入
    @Autowired
    private CustomInterceptor customInterceptor;
   public void addInterceptors(InterceptorRegistry registry) {
       //把我们定义好的拦截器对象放入注册中心通过pattern为/**对所有请求进行拦截
       registry.addInterceptor(customInterceptor).addPathPatterns("/**");
    }
}
