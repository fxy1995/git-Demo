package com.duying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.duying.mapper")
public class SpringBootDuying05OrmMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDuying05OrmMybatisApplication.class, args);
    }

}
