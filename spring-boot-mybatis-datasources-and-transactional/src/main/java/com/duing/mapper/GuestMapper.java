package com.duing.mapper;

import com.duing.domain.Guest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 7:13
 * @Version 1.0
 */
public interface GuestMapper {
    @Select("select * from guest")
    List<Guest> getAll();
}
