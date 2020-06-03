package com.duing.contoller;

import com.duing.event.EventOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 付雪缘
 * @Date 2020/5/8 8:14
 * @Version 1.0
 */
@RestController//这个注解表示返回值是json数据，因为我们没有写页面，所以随便写
@RequestMapping("/event")
public class ListenerController {
    @Autowired
    //自动注入一个发布器--发布器就是用来发布事件的
    private ApplicationEventPublisher applicationEventPublisher;
    @GetMapping
    public  String event(){
        //发布器对象通过调用方法发布事件--现在我们值要访问这个接口，系统就会自动发布事件
        applicationEventPublisher.publishEvent(new EventOne(this));
        return "我成功的启动了第一个监听器";
    }

}
