package com.duing.listener;

import com.duing.event.EventOne;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author 付雪缘
 * @Date 2020/5/8 8:35
 * @Version 1.0
 * 实现监听器的第二种方式--和第一种方式不同的是
 * 第一种方式是把监听器在启动函数中加入容器的
 * 第二种方式是通过@Component注解-让系统扫描的
 */                     //实现    接口  泛型为事件类
@Component
public class ListenerTwo implements ApplicationListener<EventOne> {
    @Override
    public void onApplicationEvent(EventOne eventOne) {
        eventOne.printMessage("--我是第二种声明监听器的方法");
    }
}
