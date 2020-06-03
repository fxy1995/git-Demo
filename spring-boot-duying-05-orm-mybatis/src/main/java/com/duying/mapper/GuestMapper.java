package com.duying.mapper;

import com.duying.domain.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 17:09
 * @Version 1.0
 */
//@Mapper通过这个注解能够表示这个类是mapper类
//但是如果我们有很多类得话。每个类上都要写@Mapper很麻烦
//所以我们在启动类上定义一个mapper扫描 @MapperScan("定义mapper文件所在得包")
public interface GuestMapper {
//    @Select("select * from guest")//通过这个注解能定义mapper中得sql语句
//    List<Guest> selectGuests();
    @Select("mybatis/mapper/GuestMapper.sql")
    List <Guest> selectGuests();
}