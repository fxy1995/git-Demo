package com.duing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 付雪缘
 * @Date 2020/5/9 15:39
 * @Version 1.0
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public  String servlet(){
        System.out.println("我是Controller");
        return "hello";
    }
}
