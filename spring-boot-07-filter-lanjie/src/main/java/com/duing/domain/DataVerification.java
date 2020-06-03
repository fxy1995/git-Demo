package com.duing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:53
 * @Version 1.0
 * 这是一个测试数据校验的domain实体类
 * 应用了JSR303规范---是一种javaEE6的一项子规范--这个规范叫BeanValidation顾名思义这个规范就是用来规范bean-即domain对象的
 * 这个规范的实现框架为 hibernate Validation 虽然叫HibernateValidation但是和Hibernate框架没有一点关系
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//如果想hibernateValidation集成SpringBoot使用的话请看testValidationController中的案例
public class DataVerification {
    @NotNull(message = "${DataVerificaton.id}")//这个注解用来规范基本类型是否为空的
    private int id;
    //这个用来规范String类型是否为null的
    @NotBlank(message = "${dataVerificaton.name}")//通过message来自定义报错的信息
    private String name;
    @NotBlank(message = "password不能为null")
    private String password;
}
