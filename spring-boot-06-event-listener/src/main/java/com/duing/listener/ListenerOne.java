package com.duing.listener;

import com.duing.event.EventOne;
import org.springframework.context.ApplicationListener;

/**
 * @Author 付雪缘
 * @Date 2020/5/8 7:43
 * @Version 1.0
 * 实现监听器的第一种方式
 */
//实现      ApplicationListener接口<泛型为声明的事件类>
public class ListenerOne implements ApplicationListener<EventOne> {
    @Override                      //参数为事件对象
    public void onApplicationEvent(EventOne eventOne) {
        //通过事件对象调用事件中的执行方法--并传入信息
        //配置完成后需要去启动类的main函数中在应用配置上下文 context中添加监听器
        eventOne.printMessage("我是第一个监听器");
    }
}
