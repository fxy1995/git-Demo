package com.duing.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author 付雪缘
 * @Date 2020/5/18 14:15
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("illness")//对应的数据库表名
public class DataBean  {//实现序列化implements Serializable
    private Long id;
    private String area;
    private int confirm;
    private int dead;
    private int heal;
    private int nowConfirm;
}
