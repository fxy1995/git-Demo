package com.duing.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author 付雪缘
 * @Date 2020/5/8 7:36
 * @Version 1.0
 * 定义一个事件类
 */
public class EventOne extends ApplicationEvent{
                //  这里的参数一边就传this--即事件对象自己
    public EventOne(Object source) {
        super(source);
    }
    //定义一个事件方法
    public  void printMessage(String msg){
        System.out.println("我是事件方法"+msg);
    }
}
