package com.duing.mapperTwo;

import com.duing.domain.Guest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 10:46
 * @Version 1.0
 */
public interface GuestMapper2 {
    @Select("select * from guest")
    List<Guest> getAll();
    @Insert("insert into guest(name,role) values(#{name},#{role})")
    void add(Guest guest);
}
