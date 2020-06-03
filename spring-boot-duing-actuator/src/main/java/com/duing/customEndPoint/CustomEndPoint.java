package com.duing.customEndPoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 付雪缘
 * @Date 2020/5/15 9:58
 * @Version 1.0
 * 自定义端点
 */
@Component//表示这是spring组件需要进行扫描
@Endpoint(id = "testEndpoint")//表示这是一个端点-id的值为端点的接口
public class CustomEndPoint {
    //自定义方法
    @ReadOperation//表示查看端点时显示相应的方法
    @ResponseBody//因为返回值都是以json类型返回的所以需要写这个注解
    public Map<String,String> testEndpoint(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("name","我是自定义端点这是我的name属性的值");
        resultMap.put("message","我要加油了");
        return resultMap;
        //此时我们就能访问 testEndpoint端口来获取里面的信息了
    }
}
