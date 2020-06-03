package com.duing.controller;

import com.duing.domain.Student;
import com.duing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/15 11:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getAll(){
        System.out.println(studentService.getAll());
        return studentService.getAll();
    }
    @GetMapping("/{id}")
    public  Student getById(@PathVariable("id") int id){
        System.out.println("id___"+id);
        return studentService.getById(id);
    }

}
