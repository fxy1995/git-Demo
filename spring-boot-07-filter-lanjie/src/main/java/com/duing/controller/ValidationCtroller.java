package com.duing.controller;

import com.duing.domain.DataVerification;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 16:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/testOne")
public class ValidationCtroller {
    @PostMapping
    //通过@Valid来引入HibernateValidation 对dataVerification对象进行数据校验
    //校验规则写在domain实体类的属性上 BindingResult对象是用来获取失败信息的
    public String add(@Valid DataVerification dataVerification, BindingResult bindingResult){
int errorCount= bindingResult.getErrorCount();
        System.out.println(errorCount);
        List<FieldError> errors= bindingResult.getFieldErrors();
 for (FieldError error:errors){
     System.out.println(error.getField());//获取字段名
     System.out.println(error.getDefaultMessage());//获取错误信息
     StringBuilder sb=new StringBuilder(error.getField()+error.getDefaultMessage());
     return sb.toString();
 }
        return "message";
    }
}
