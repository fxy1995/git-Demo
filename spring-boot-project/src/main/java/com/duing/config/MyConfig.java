package com.duing.config;

import com.duing.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @Author 付雪缘
 * @Date 2020/6/3 11:39
 * @Version 1.0
 */
@Configuration
public class MyConfig {
    @Bean                //我们的bean的名字和方法名是一样的-所以方法名按照小驼峰式书写-不然系统读取不到
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();//创建出的对象当作Bean交给Spring管理
    }

}
