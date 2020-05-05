package com.duing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tk.Mybatis设置扫描mapper包
//@MapperScan("com.duing.tx.mapper")
//mybatis-plus 扫描mapper包
@MapperScan("com.duing.plus.mapper")
@SpringBootApplication
public class SpringBoot_MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot_MybatisApplication.class, args);
    }

}
