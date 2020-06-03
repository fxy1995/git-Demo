package com.duing.listener;

import com.duing.event.EventOne;
import org.springframework.context.ApplicationListener;

/**
 * @Author 付雪缘
 * @Date 2020/5/8 8:57
 * @Version 1.0
 * 实现监听器的第四种方式
 * 需要实现ApplicationListener<事件类></>
 * 配置完之后还需要再application.yml或者 .properties文件种添加
 * context:------这个表示容器
 *    listener------这个表示是一个监听器
 *      classes：xxx----值为我们定义的监听器类的类全名
 */
public class Listenerfour implements ApplicationListener<EventOne> {
    @Override
    public void onApplicationEvent(EventOne eventOne) {
        eventOne.printMessage("----我是第四种声明监听器的方式");
    }
}
