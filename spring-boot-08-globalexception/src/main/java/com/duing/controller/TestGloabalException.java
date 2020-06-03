package com.duing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 付雪缘
 * @Date 2020/5/11 9:58
 * @Version 1.0
 */

@Controller
//这是普通风格的写法
public class TestGloabalException {
    @RequestMapping("/testException2")
    @ResponseBody
    public  String test2() throws Exception {
        //这里抛出了一个异常，为了测试全局异常
        throw  new ClassNotFoundException("测试全局异常之找不到类");
    }
    @RequestMapping("/testException")
    public  String test() throws Exception {
        //这里抛出了一个异常，为了测试全局异常的处理
   throw  new Exception("我测试全局异常处理");
    }
}
