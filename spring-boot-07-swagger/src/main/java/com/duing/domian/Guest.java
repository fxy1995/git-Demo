package com.duing.domian;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;

/**
 * @Author 付雪缘
 * @Date 2020/5/11 14:52
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("嘉宾domain对象")//这个是swagger框架中的注解
public class Guest {
    @ApiModelProperty("嘉宾id")
    private  int id;
    @ApiModelProperty("嘉宾名字")
    private String name;
    @ApiModelProperty("嘉宾角色")
    private String role;
}
