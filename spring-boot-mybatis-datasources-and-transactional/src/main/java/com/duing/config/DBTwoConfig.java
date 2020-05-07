package com.duing.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 10:35
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.duing.mapperTwo",sqlSessionFactoryRef = "sqlSessionFactoryTwo")
public class DBTwoConfig {
    @Autowired
    @Qualifier("db2")
    private DataSource dataSource;
    @Bean
    public SqlSessionFactory sqlSessionFactoryTwo()throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);//把数据源(工厂得设计图交给SqlSessionFactoryBean)
      return sqlSessionFactoryBean.getObject();
    }

    @Bean
    //sqlSessionTemplate对象是负责调用mybatis的sql方法的
    public SqlSessionTemplate sqlSessionTemplateTwo () throws Exception{
        //我们创建带SqlSessionFactory参数得 sqlSession模板 参数就是我们上面的sqlSessionFactoryTwo方法的返回值
        SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactoryTwo());
        return sqlSessionTemplate;
    }
}
