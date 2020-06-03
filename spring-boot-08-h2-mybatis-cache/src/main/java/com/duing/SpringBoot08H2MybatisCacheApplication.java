package com.duing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching//这个注解表示使用缓存
@MapperScan("com.duing.mapper")//这个注解用来扫描mapper
@SpringBootApplication
public class SpringBoot08H2MybatisCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08H2MybatisCacheApplication.class, args);
    }

}
