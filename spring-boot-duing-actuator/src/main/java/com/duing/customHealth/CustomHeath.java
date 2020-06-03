package com.duing.customHealth;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Author 付雪缘
 * @Date 2020/5/15 9:50
 * @Version 1.0
 * 自定义健康指示器 首先需要实现HealthIndicator接口然后实现health方法
 *
 */
@Component//让spring扫描到
public class CustomHeath implements HealthIndicator {
    @Override
    public Health health() {
        int CustomCode = 0;//这个健康码你可以根据你监控的指标值获取
        if (CustomCode == 0) {//定义健康指标的区间值，超过值就返回不健康指标
       return  Health.down().withDetail("Errocode","CustomCode大于1超过了预期值").build();
        }
        return Health.up().build();//up表示健康指标
        //设置完成后，这个指标就再health指标之中了-方法名就是小的指标名
    }
}
