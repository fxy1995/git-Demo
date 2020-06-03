package com.duing.filter.config;

import com.duing.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:07
 * @Version 1.0
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<CustomFilter> filterFilterRegistrationBean(){
        FilterRegistrationBean<CustomFilter> filterFilterRegistrationBean=new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new CustomFilter());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(0);
        return filterFilterRegistrationBean;
    }
}
