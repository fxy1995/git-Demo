package com.duing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 8:51
 * @Version 1.0
 */
@Configuration//这个注解表示这个类是一个Configuration对象
// 《相当与以前的configuration.xml配置文件的对象-里面包含了数据源，事务，mapper等等》
public class DBConfig {

    @Bean(name = "db1")//@Bean("db1")相当于在spring配置了一个名字为db1的bean对象
    //相当于以前configuration.xml文件中的配置的一个数据源
    @ConfigurationProperties("spring.datasource.db1")//读取配置，以前我们用@value太麻烦
    public DataSource dataSource1(){//创建Datasource对象这个对象的赋值是通过上面@ConfiguraitonProperties读取到的配置文件中得数据进行赋值的
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")//相当于以前configuration.xml文件中的配置的一个数据源
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }
}
