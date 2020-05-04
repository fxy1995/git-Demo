package com.duing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 付雪缘
 * @Date 2020/5/2 9:42
 * @Version 1.0
 */
@Controller
public class TestThymeleafController {
    //通过这个接口找到index页面
    @RequestMapping("/index")
    public String toIndex(){
        return "/thymeleaf/index";
    }
    //index页面通过url链接表达式@{/test}找到/test接口返回test页面
    @RequestMapping("/test")
    public  String toTest(){
        return "/thymeleaf/test";
    }
}
