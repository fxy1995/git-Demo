package com.duing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Author 付雪缘
 * @Date 2020/5/2 7:20
 * @Version 1.0
 */
@Controller
public class TestFreemarkerController {
    @RequestMapping("/testFreemarker")
    public String testFreemarker(Model model){
        Date date=new Date();
        model.addAttribute("date",date);
        return "/thymeleaf/index";
    }
}
