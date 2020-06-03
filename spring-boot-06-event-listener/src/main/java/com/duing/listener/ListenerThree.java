package com.duing.listener;

import com.duing.event.EventOne;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author 付雪缘
 * @Date 2020/5/8 8:41
 * @Version 1.0
 * 创建监听器的第三种方式
 * 很简单,不用实现接口
 * 需要在类上写@Component
 * 在方法上写@EventListener
 */

@Component   //告诉系统这是一个需要扫描的bean
public class ListenerThree {
    //随便写一个方法--事件对象当作参数
    @EventListener//告诉系统这是一个事件监听的bean
    public  void applicationEvent(EventOne eventOne){
       eventOne.printMessage("----我是第三种实现监听器的方式");
    }
}
