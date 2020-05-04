package com.duying.controller;

import com.duying.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 15:55
 * @Version 1.0
 */
@RequestMapping("/guest")
@Controller
public class GuestController {
    @Autowired
    private GuestService guestService;
    @GetMapping
    public String list(Model model){
        model.addAttribute("guests",guestService.list());
        return "guestList";
    }
}
