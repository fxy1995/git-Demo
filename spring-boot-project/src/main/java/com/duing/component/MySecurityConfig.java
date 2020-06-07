package com.duing.component;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author 付雪缘
 * @Date 2020/6/6 11:26
 * @Version 1.0
 */
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 定制某些请求的权限
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");


        // 设置登录页 和 登录参数
        http.formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login");

        // 确认自定义的登录页地址
        // 默认的表单处理逻辑
    }

    // 新版本增加了 对密码加密的强制需求
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String pwd = new BCryptPasswordEncoder().encode("123456");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(pwd).roles("VIP1","VIP2","VIP3")
                .and()
                .withUser("student").password(pwd).roles("VIP1","VIP2")
                .and()
                .withUser("guest").password(pwd).roles("VIP1");
    }
//    protected void configure(HttpSecurity http) throws Exception {
////设置某些请求的权限
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/level1/**").hasRole("VIP1")//表示角色VIP1能够访问/level1/下的所有路径
//                .antMatchers("/level2/**").hasRole("VIP2")
//                .antMatchers("/level3/**").hasRole("VIP3");
//        //设置登录页和登录参数--因为security框架默认给了我们一个登录页，但是我们需要使用自己定义的登录页所以需要设置
//        //                          登录页路径              登录页上用户名输入框的name值       密码框的name值
//        http.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password");
//    }
////用来设置用用户和角色的对应关系
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//  //  String pwd="123456";
////新版本需要对密码进行强制加密
//    String pwd= new BCryptPasswordEncoder().encode("123456");
//        System.out.println("pwd"+pwd);
//    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//            .withUser("root").password(pwd).roles("VIP1","VIP2","VIP3")//设置root这个用户的角色
//            .and()
//            .withUser("zs").password(pwd).roles("VIP1","VIP2")
//            .and()
//            .withUser("ls").password(pwd).roles("VIP1");
//    }

}
