package com.duing.globalExceptionConfig;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 付雪缘
 * @Date 2020/5/11 10:11
 * @Version 1.0
 * 自定义一个类
 */
@ControllerAdvice//标记为控制层的切面
public class GlobalHandler {
    //这里声明一个异常页面的名字--如果出现异常，系统就会去resources文件夹下的templates文件夹中去找名字为这个的html页面
    private static final String DEFAULT_ERROR_VIEW="/error";//这个名字随便写注意要夹/相当于template/error文件

@ExceptionHandler(Exception.class)//这个注解表示我们要对什么一场进行处理--因为我们要处理所有的异常所以我们写Exception所有异常的父类
//当出现异常时就会跳转到此方法
public ModelAndView handler(HttpServletRequest request,Exception e){//因为我们要处理异常，我们得拿到异常对象，参数就是发生异常的异常对象
    ModelAndView modelAndView= new ModelAndView(DEFAULT_ERROR_VIEW);//把静态常量传入对象中--出错后系统就会在resources文件夹中找名字为这个的页面
  //在ModelAndView构造方法中传递名字就相当于写 modelAndView.setViewName("/error"); 详情看构造方法源码
 modelAndView.addObject("exception",e);//把异常对象传入--可以在前端页面获取
  modelAndView.addObject("urlPath",request.getRequestURL());//获取请求路径-表示发送什么请求时出的错误
//    //上面add的对象--都会以json的格式传入页面中，页面通过${key}获取对应的value
    return modelAndView;
}
}
