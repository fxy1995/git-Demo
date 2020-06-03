package com.duing.controller;

import com.duing.component.MailComponent;
import com.duing.component.MailComponent2;
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
    private MailComponent mailComponent;
    @Autowired
    private  MailComponent2 mailComponent2;
    @Autowired
    private DataServiceImp dataServiceImp;
    @GetMapping("/list")
    public String list(Model model){
//        //测试邮件发送-随便写在这里测试一下
//        mailComponent.send();
        //测试邮件发送-随便写在这里测试一下
        try {
            mailComponent2.send();
        }catch (Exception e){
            e.printStackTrace();
        }
        //正常的数据展示
        List<DataBean> list=dataServiceImp.list();
        model.addAttribute("datas",list);
        return "list";

    }

}
