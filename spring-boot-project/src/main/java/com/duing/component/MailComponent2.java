package com.duing.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 付雪缘
 * @Date 2020/6/3 17:28
 * @Version 1.0
 */
@Component
public class MailComponent2 {
    @Autowired
    private JavaMailSender javaMailSender;//这个对象用来发送邮件
    @Autowired
    private TemplateEngine templateEngine;//这是thymeleaf模板引擎
    public  void send() throws Exception{
        System.out.println("准备发送html内容邮件");
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
       //帮助邮件数据的对象
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
       //对邮件进行设置
        helper.setSubject("我是邮件标题");
        //因为我们要配置thymeleaf进行使用所以我们需要渲染html页面-这就相当于模板文件
        Context context=new Context();
        //创建一个map集合存储html页面需要的信息
        Map<String,Object> messageMap=new HashMap<>();
        messageMap.put("title","我是thymeleaf文件的标题");
        messageMap.put("body","我是模板文件的内容</br>土豆土豆，我是地瓜，收到请回答");
        //把数据赋予给context 就能再thymeleaf模板的html页面上通过${key}拿到值
        context.setVariables(messageMap);//渲染好了html页面的内容
        //设置我们需要对哪个html页面进行渲染-并把内容进行传入
        String content=templateEngine.process("testMail",context);
        //把渲染好的html真个页面当作邮件的内容传入，并且说明是一个html文件
        helper.setText(content,true);
        //设置发送给谁
       helper.setTo("2387450703@qq.com");
       //设置发送人--即本人
       helper.setFrom("1460793107@qq.com");
       //添加附件
        //附件文件
        File file=new File("D:/一期/abc.txt");
        //传入附件文件
        FileSystemResource fileSystemResource=new FileSystemResource(file);
        //写入附件名称和fileSystemResource对象
        helper.addAttachment("这是测试附件",fileSystemResource);
       //发送邮件
        javaMailSender.send(mimeMessage);
        System.out.println("邮件已发送");
    }
}
