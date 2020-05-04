package com.duing.controller;

import com.duing.domain.Guest;
import com.duing.servece.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 付雪缘
 * @Date 2020/5/2 10:56
 * @Version 1.0
 */
@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;
@GetMapping
    public String list(Model model){
        model.addAttribute("list",guestService.list() );
return "/thymeleaf/guestList";
    }

@GetMapping("/toAdd")
    public String toAdd(){
  return "/thymeleaf/guestAdd";
    }
@PostMapping
    public String add(Guest guest){//如果前端标签中的name和对象中的属性名一样，是可以自动组合成对象的
        guestService.add(guest);
     //添加完成后请求重定向访问toGuestList接口让用户看到新增的人员信息
    return "redirect:/guest";
    }
@DeleteMapping("/{name}")
    public String delete(@PathVariable("name")  String name){
       System.out.println("name");
  guestService.delete(guestService.getGuestByName(name));
return "redirect:/guest";
    }
@GetMapping("/toUpdate/{name}")
    public String toUpdate(Model model, @PathVariable("name") String name){
        //1.我们通过name获取整个对象，因为修改页面需要对象的所有值
        Guest guest=guestService.getGuestByName(name);
        //2.把值存入model中
        model.addAttribute("guest",guest);
        //进入修改页面
  return "/thymeleaf/guestUpdate";
    }
@PutMapping
    public String update(Guest guest){
        guestService.update(guest);
  return "redirect:/guest";
    }
}
