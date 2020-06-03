package com.duing.component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author 付雪缘
 * @Date 2020/6/3 11:32
 * @Version 1.0
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
       //获取传递过来的参数-让我们知道是语言类型
        String l=httpServletRequest.getParameter("f");
        System.out.println("------"+l);
        Locale locale=Locale.getDefault();//获取一个默认的local对象
        //如果参数不为null的话
        if (!StringUtils.isEmpty(l)){
         String [] split=l.split("_");
            System.out.println(split[0]);
            System.out.println(split[1]);
            locale=new Locale(split[0],split[1]);//重新构造出一个新的locale对象返回
        }
        return locale;
        //写完之后还需要让spring管理整个locale的Bean-详情看我们自己写的config包下的类
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
