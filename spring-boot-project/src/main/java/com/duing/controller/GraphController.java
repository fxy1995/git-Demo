package com.duing.controller;

import com.duing.data.GraphHandler;
import com.duing.domain.GraphDataBean;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 付雪缘
 * @Date 2020/5/30 18:26
 * @Version 1.0
 */
@Controller
@RequestMapping("/graph")
public class GraphController {
    @GetMapping("/list")
    public String list(Model model){
        List deadList=new ArrayList();
        List healList=new ArrayList();
        List confirmList=new ArrayList();
        List dateList=new ArrayList();
        ArrayList<GraphDataBean> list= GraphHandler.getData();
        System.out.println("zuida"+list.get(list.size()-1).getDate());
        for ( int i=0;i<list.size();i=i+10){
            GraphDataBean graphDataBean=null;
            if (i<list.size()) {

                graphDataBean=list.get(i);
            }

            dateList.add(graphDataBean.getDate());
            deadList.add(graphDataBean.getDead());
            healList.add(graphDataBean.getHeal());
            confirmList.add(graphDataBean.getConfirm());
            if(i+10>list.size()-1){
                graphDataBean=list.get(list.size()-1);
                dateList.add(graphDataBean.getDate());
                deadList.add(graphDataBean.getDead());
                healList.add(graphDataBean.getHeal());
                confirmList.add(graphDataBean.getConfirm());
            }
        }
        System.out.println("我执行了");
        Gson gson=new Gson();
        model.addAttribute("dateList",gson.toJson(dateList));
        model.addAttribute("deadList",gson.toJson(deadList));
        model.addAttribute("healList",gson.toJson(healList));
        model.addAttribute("confirmList",gson.toJson(confirmList));
        return "graph";
    }
}
