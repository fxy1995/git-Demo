package com.duing.config;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 9:29
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.duing.mapper",sqlSessionFactoryRef ="sqlSessionFactoryOne" )
public class DBOneConfig {
    @Autowired
    @Qualifier("db1")//这里通过名字去获取具体的bean，我们的bean都声明在DBconfig中
    private DataSource dataSource;//这里是第一套数据源的自动注入


    @Bean
    public SqlSessionFactory sqlSessionFactoryOne() throws Exception{
        //创建一个sqlSesion工厂的bean对象
        SqlSessionFactoryBean sqlSessionFactoryBean= new SqlSessionFactoryBean();
        //我们把工厂的数据源设置进去----相当于告诉它我们使用哪一套数据方案
        sqlSessionFactoryBean.setDataSource(dataSource);
        //因为是sqlsessionFactoryBean工厂--工厂模式，所以我们通过getObject 获取到一个具体的sqlSessionFactory对象
        return  sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateOne() throws Exception {
     SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactoryOne());
     return sqlSessionTemplate;

    }

}
