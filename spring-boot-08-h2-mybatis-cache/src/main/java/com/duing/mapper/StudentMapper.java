package com.duing.mapper;

import com.duing.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/15 10:57
 * @Version 1.0
 */
public interface StudentMapper {
    @Select("select id,name,role from student")
     List<Student> getAll();
    @Select("select  id,name,role from student where id=#{id}")
    Student getById(@Param("id") int id);
}
