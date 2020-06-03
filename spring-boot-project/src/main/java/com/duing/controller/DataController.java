package com.duing.controller;

import com.duing.domain.DataBean;
import com.duing.service.DataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/18 14:33
 * @Version 1.0
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataServiceImp dataServiceImp;
    @GetMapping("/list")
    public String list(Model model){
        List<DataBean> list=dataServiceImp.list();
        model.addAttribute("datas",list);
        return "list";

    }

}
