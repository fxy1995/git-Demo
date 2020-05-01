package com.duyi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author 付雪缘
 * @Date 2020/4/30 18:43
 * @Version 1.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "greeting")
public class GreetingConfig {
    private long id;
    private String content;
    public  long sid(long id){
        return id;
    }
}
