package com.duing.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author 付雪缘
 * @Date 2020/6/6 9:46
 * @Version 1.0
 */
/**
 * 声明种这是一个切面功能的组件
 * */
@Aspect
@Component
public class LogAspect {
    //因为我们是做日志功能的切面，所以我们选择slf4j(springBoot自带的日志Logger对象)
    //注意是slf4j包下的logger
    private Logger logger= LoggerFactory.getLogger(this.getClass());//参数就是当前类的class
    //这个execution表达式表示我们在执行com.duing.service包下所有的类方法时都会启用这个日志切面
    @Before("execution(* com.duing.service..*.*(..))")
    public  void log(){
        logger.info("我是方法之前执行的日志");
    }
    @After("execution(* com.duing.service..*.*(..))")
    //参数得到JoinPoint就是我们切面的切点-注意是这个包下的org.aspectj.lang.JoinPoint
    //我们可以通过切点获取我们是具体执行哪个方法来执行打印日志的
    public void after(JoinPoint joinPoint){
        logger.info("我是方法之后执行的日志打印");
        logger.info("执行了哪个类时打印的日志----"+joinPoint.getTarget().getClass());
        logger.info("类中的--"+joinPoint.getSignature()+"方法");
        logger.info("方法中的参数"+joinPoint.getArgs());
    }



}
