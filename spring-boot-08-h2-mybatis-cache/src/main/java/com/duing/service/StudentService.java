package com.duing.service;

import com.duing.domain.Student;
import com.duing.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/15 11:02
 * @Version 1.0
 */
@Service
public class StudentService {
@Autowired
private StudentMapper studentMapper;
public List<Student> getAll(){

    return studentMapper.getAll();
}
//想要使用缓存首先我们要在主函数类上添加@EnableCaching 注解表示使用注解
    //然后再service层具体方法上用@Cacheable("给这个缓存起个名字")
    //当我们需要查询的数据都时一样的时候，例如我们查询了两次id为1的用户
   // 第一次查询时，系统会看有没有开启缓存，如果开启了缓存，系统就会把第一次查询的结果放入缓存中
   // 第二次再查询id为1的时候就会直接从缓存中取数据，不会在访问数据库了
    //Cacheable注解中常用的三个属性
  /** cacheNames=缓存名
    key=缓存的id*-
     condition=开启缓存的条件--满足条件才进行缓存
                与之相反的
            unless=不满足这个条件才会开启缓存*/
//@Cacheable(cacheNames = "testCache",key = "1",condition = "#id>1")
  @Cacheable(cacheNames = "testCache",key = "#id",unless = "#id>1")
public  Student getById(int id){
    System.out.println("我进来了");
    return studentMapper.getById(id);
}
@CachePut(cacheNames = "testCache" ,key="#id")
    public  Student update(Student student){
      return student;
}

}
