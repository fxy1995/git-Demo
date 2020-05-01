package com.duyi.controller;

import com.duyi.config.MenuConfig;
import com.duyi.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 付雪缘
 * @Date 2020/5/1 6:59
 * @Version 1.0
 */
@RestController
public class MenuController {
    @Autowired
    private MenuConfig menuConfig;
    @RequestMapping("/getMenu")
    public Menu getMenu(){
        return new Menu(menuConfig.getMeal(),menuConfig.getFood(),menuConfig.getSauce());
    }
}
