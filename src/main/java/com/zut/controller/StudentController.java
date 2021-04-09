package com.zut.controller;

import com.zut.entity.Student;
import com.zut.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/evaluation")
public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    @ResponseBody
    @GetMapping("/login11")
    public List<Student> hello(){
        return studentMapper.findAll();
    }
}
