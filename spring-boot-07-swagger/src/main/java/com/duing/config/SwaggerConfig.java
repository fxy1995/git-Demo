package com.duing.config;

import com.duing.domian.Guest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author 付雪缘
 * @Date 2020/5/11 13:25
 * @Version 1.0
 * 自定义一个类作为swagger框架的配置类
 * 设置完成之后通过 http://localhost:8080/swagger-ui.html进行访问文档
 */
@Configuration//表示是一个配置类
@EnableSwagger2//表示使用Swagger2框架
public class SwaggerConfig {
    @Bean //说明返回值是一个spring需要管理的domain  bean对象
    //Docket 是摘要的意思
    public Docket api(){
        // DocumentationType.SWAGGER_2表示使用Swagger2
        Docket docket=new Docket(DocumentationType.SWAGGER_2).select()
                //apis表示查看生成哪些Controller接口  any()表示全部controller接口
//                .apis(RequestHandlerSelectors.any())
                //这个是设置只对哪个路径下的接口进行扫描
                .apis(RequestHandlerSelectors.basePackage("com.duing.controller"))
                //要展示所有接口
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());//设置apiInfo表示设置文档中文介绍
        //配置完成
        return  docket;
    }
    //通过apiInfo设置文档中中文提示--自定义文档介绍
    public ApiInfo apiInfo(){
        //通过apiInfoBuilder进行设置
        return  new ApiInfoBuilder()
                .title("spring-boot-07-swagger")//设置文档标题（一般和项目名保持一致）
                .description("这是一个用来测试的文档")//设置基本描述信息
                .version("1.0")//设置版本
                .build();//创建成功--设置成功后让上面方法中的Docket对象进行引入
    }

}
