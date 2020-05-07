package com.duing.controller;

import com.duing.domain.Guest;
import com.duing.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 7:17
 * @Version 1.0
 */
@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;
    @GetMapping
    public String  getAll(Model model){
        model.addAttribute("guests",guestService.getAll());
        return "/thymeleaf/guestList";
    }
    @GetMapping("/toAdd")
    public  String toAdd(){
return "/thymeleaf/guestAdd";
    }

@Transactional//注意这个@Transactional事务不能用在多数据源情况下
  @PostMapping
    public  String add(Guest guest){
        guestService.add(guest);
        int i=1/0;
        return "redirect:/guest";
  }
}
