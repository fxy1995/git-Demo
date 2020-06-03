package com.duing;

import com.duing.listener.ListenerOne;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@SpringBootApplication
public class SpringBoot06EventListenerApplication {

    public static void main(String[] args) {
        //接受创建完成的上下文容器
    ConfigurableApplicationContext context=SpringApplication.run(SpringBoot06EventListenerApplication.class,args);
      //把监听器对象添加入容器中---如何触发事件呢？---去controller中配置
        context.addApplicationListener(new ListenerOne());
    }
    //响应式开发
    @Bean
    public RouterFunction<ServerResponse> helloworld(){
                  //请求                                            返回的资源
   return route(GET("/hello"),request->ok().body(Mono.just("HelloWord"),String.class));
    }
//查看当前创建的容器---tomcat  or jetty  or Undertow
   @Bean
    public ApplicationRunner runner(WebServerApplicationContext context){
        return  args -> {
            System.out.println("当前webServer的实现类为"+context.getWebServer().getClass().getName());
        };
   }
}
