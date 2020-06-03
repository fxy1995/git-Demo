package com.duing.controller;

import com.duing.domian.Guest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author 付雪缘
 * @Date 2020/5/11 14:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
//   tags的设置是把接口名设置成了值 （个人觉得不用设置这个）     description是设置controller的描述
@Api(tags = "这是一个嘉宾的增删改查接口",description = "这是对嘉宾的增删改查")//这个是用来在文档中描述这个controller层类信息的注解
public class TestSwaggerMannegerController {
    @GetMapping
    @ApiOperation("嘉宾的增加接口")//这是用来描述具体某个接口信息的注解
    @ResponseBody
    public  Guest add(Guest guest1){
        return guest1;
    }
    @DeleteMapping
    @ApiOperation("这是删除接口")
    //这个注解是专门用来描述非domain对象的参数的
    @ApiImplicitParam(name="id",value = "用户id")
    public  String delete(int id){
        return "delete";
    }
    //这个test接口是用来测试忽略这个接口的
    @PutMapping
    @ApiIgnore//设置上这个注解就表示忽略这个接口咯
    public  String test(){
      return "test";
    }
}
