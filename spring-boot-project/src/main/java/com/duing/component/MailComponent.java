package com.duing.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @Author 付雪缘
 * @Date 2020/6/3 16:39
 * @Version 1.0
 */
@Component
public class MailComponent {
    @Autowired
    private JavaMailSender mailSender;
    public  void send(){
        System.out.println("开始准备发送邮件");
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        //设置邮件主题
        simpleMailMessage.setSubject("第一封springBoot邮件的发送使用");
        //设置邮件内容
        simpleMailMessage.setText("土豆土豆，我是地瓜，收到请回答，收到请回答,over，over");
        //设置发送给谁
        simpleMailMessage.setTo("2387450703@qq.com");
        simpleMailMessage.setFrom("1460793107@qq.com");
        //邮件发送
        mailSender.send(simpleMailMessage);
        System.out.println("邮件以发出");
    }
}
