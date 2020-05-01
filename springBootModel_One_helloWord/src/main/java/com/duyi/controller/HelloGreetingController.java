package com.duyi.controller;

import com.duyi.config.GreetingConfig;
import com.duyi.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author 付雪缘
 * @Date 2020/4/30 7:08
 * @Version 1.0
 */
@RestController
public class HelloGreetingController {
  @Autowired
  private GreetingConfig greetingConfig;
    @GetMapping("/helloGreeting")
    public Greeting HelloGreeting(){
   return  new Greeting(greetingConfig.getId(),greetingConfig.getContent());
    }
}
