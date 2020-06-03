package com.duing.controller;

import com.duing.globalExceptionConfig.GlobalHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 付雪缘
 * @Date 2020/5/11 11:29
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class RestFulStyleController {
    @GetMapping
    //使用restful风格方法的返回值必须是我们定义的处理异常类
    public GlobalHandler test() throws Exception{
      throw new Exception("我是RestFul风格的全局异常测试");
    }
}
