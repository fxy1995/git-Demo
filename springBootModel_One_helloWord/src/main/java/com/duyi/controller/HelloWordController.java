package com.duyi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 付雪缘
 * @Date 2020/4/29 19:15
 * @Version 1.0
 */
@RestController
public class HelloWordController {
    @Value("${info.username}")
    private String username;
    @Value("${info.password}")
    private String password;
    @GetMapping("/helloWord")
    public String HelloWord(){
        return username+"-----------"+password;
    }

}
