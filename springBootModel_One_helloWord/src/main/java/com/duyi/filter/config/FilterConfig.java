package com.duyi.filter.config;

import com.duyi.filter.FilterDemoTwo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 14:27
 * @Version 1.0
 * 需要继承过滤器注册bean 泛型为自定义的filter类
 * 需要告诉系统这是一个配置类，通过@Cfiguraion注解
 */
@Configuration
public class FilterConfig extends FilterRegistrationBean<FilterDemoTwo> {
   //随便写一个方法 方法的返回值为FilterRegistrationBean
   @Bean
   public  FilterRegistrationBean gistr(){
        FilterRegistrationBean beanOne=new FilterRegistrationBean<>();
       //把我们的filter对象添加值容器中
     beanOne.setFilter(new FilterDemoTwo());
    //设置要拦截的请求是什么
      beanOne.addUrlPatterns("/*");
     //设置优先级
       beanOne.setOrder(1);
      return beanOne;

    }
}
