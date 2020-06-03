package com.duyi;

import com.duyi.config.GreetingConfig;
import com.duyi.config.MenuConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author 付雪缘
 * @Date 2020/4/29 18:19
 * @Version 1.0
 */
//这个注解表示标注这是一个springboot应用的入口
//    @ServletComponentScan
@SpringBootApplication
@EnableConfigurationProperties({GreetingConfig.class, MenuConfig.class})
public class SpringApplicationMain {
    public static void main(String[] args) {
        //使用SpringApplication静态方法启动SpringBoot程序
        SpringApplication.run(SpringApplicationMain.class,args);
    }
}
