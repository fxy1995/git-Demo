package com.duing.testDataVerification;

import com.duing.domain.DataVerification;

import javax.validation.*;
import java.util.Set;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 16:07
 * @Version 1.0
 * 这个类是自定义类，用来测试hibernateValidation规范的一个小Demo
 */
public class Mytest {
    public static void main(String[] args) {
        //创建一个validator实例
        Validator validator= Validation.buildDefaultValidatorFactory().getValidator();
        //创建一个不符合要求的实体domain对象
        DataVerification dataVerification=new DataVerification(1,"","");
        //进行bean对象的数据校验
    Set<ConstraintViolation<DataVerification>> msgSet= validator.validate(dataVerification);
    for (ConstraintViolation violation:msgSet){
        //打印错误字段
        System.out.println(violation.getPropertyPath());
        //答应错误字段的错误信息--错误信息可以再domian对象字段的注解中的message属性中自定义错误信息
        System.out.println(violation.getMessage());
    }
        System.out.println("===============================");
    //利用上面的方式--会打印全部的错误信息--但是效率低-这种模式叫做普通模式
        //普通模式遍历了所有的错误，而我们需要发现一个错误就算出错了，不符合规范，不需要再看其他错误了
        //就像一旦少于80分就算差生了，不需要再往后看错题了
        //有一种新的模式叫 快速错误(fastFail)--我们发现一个错误就直接返回
        //创建一个快速失败模式的实例
        Validator validatorFastFail = Validation.byDefaultProvider().configure()
                .addProperty("hibernate.validator.fail_fast","true").
                        buildValidatorFactory().getValidator();
        //进行bean对象的数据校验
        Set<ConstraintViolation<DataVerification>> msgSet2= validatorFastFail.validate(dataVerification);
        for (ConstraintViolation violation:msgSet2){
            //打印错误字段
            System.out.println(violation.getPropertyPath());
            //答应错误字段的错误信息--错误信息可以再domian对象字段的注解中的message属性中自定义错误信息
            System.out.println(violation.getMessage());
        }

    }
}
