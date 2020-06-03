package com.duying.controller;

import com.duying.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 17:18
 * @Version 1.0
 */
@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;
    @GetMapping
    public String selectGuests(Model model){
        System.out.println("okkkkkk");
        model.addAttribute("guests",guestService.selectGuests());
        return "/guestList";
    }
}
