package com.duyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @Author 付雪缘
 * @Date 2020/5/1 10:07
 * @Version 1.0
 */
@Controller
public class TestFreemarkerController {
    @RequestMapping("/toTestFreemarker")
    public String testFreemarker(Model model){
        model.addAttribute("now",new Date().toString());
        return "test";
    }
}
