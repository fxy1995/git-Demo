package com.duing.controller;

import com.duing.domain.Guest;
import com.duing.service.TestServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/28 12:25
 * @Version 1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestServiceImp testServiceImp;
    @GetMapping("/test1")
    public void test(){
        System.out.println("我是test的controller");
     List<Guest> list= testServiceImp.list();
        System.out.println(list);
    }
}
