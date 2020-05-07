package com.duing;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//不能使用mapper资源扫描-因为我们不同的数据源对应得mapper上得sql也是不同的
//@MapperScan("com.duing.mapper")
@MapperScan("com.duing.mapperTwo")
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}
