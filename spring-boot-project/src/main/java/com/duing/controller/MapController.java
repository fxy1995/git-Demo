package com.duing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 付雪缘
 * @Date 2020/5/31 9:05
 * @Version 1.0
 */
@Controller
@RequestMapping("/map")
public class MapController {
    @GetMapping
    public String list(){
        return "map";
    }
}
