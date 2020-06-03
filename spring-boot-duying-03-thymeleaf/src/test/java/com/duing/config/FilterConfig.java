package com.duing.config;
import com.duing.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 14:46
 * @Version 1.0
 */
@Configuration
public class FilterConfig  {
    //随便写一个方法 方法的返回值为FilterRegistrationBean
    @Bean
    public FilterRegistrationBean<TestFilter>  registerKeywordHandleFilter(){
        FilterRegistrationBean beanOne=new FilterRegistrationBean<>();
        //把我们的filter对象添加值容器中
        beanOne.setFilter(new TestFilter());
        //设置要拦截的请求是什么
        beanOne.addUrlPatterns("/*");
        //设置优先级
        beanOne.setOrder(1);
        return beanOne;

    }
}
