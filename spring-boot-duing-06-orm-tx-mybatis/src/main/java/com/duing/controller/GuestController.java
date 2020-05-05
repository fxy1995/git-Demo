package com.duing.controller;

import com.duing.service.GuestService;
import com.duing.service.GusetServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 付雪缘
 * @Date 2020/5/5 17:51
 * @Version 1.0
 */
@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GusetServiceImp gusetServiceImp;
    @GetMapping
    public String list(Model model){
        model.addAttribute("guests",gusetServiceImp.list());
        return "thymeleaf/guestList";
    }
}
