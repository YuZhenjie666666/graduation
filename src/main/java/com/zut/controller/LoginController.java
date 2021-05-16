package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Student;
import com.zut.entity.Teacher;
import com.zut.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

//@ResponseBody
@Controller
@RequestMapping("/evaluation")
public class LoginController {
    @Autowired
    LoginMapper loginMapper;

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody Student student){
        String flag = "error";
        Student student1 = loginMapper.getStudentMessage(student.getSname(),student.getSpassword());
//        System.out.println("这是传入的参数"+student+"  ");
//        System.out.println(student1);
        HashMap<String,Object> res = new HashMap<>();
        if(student1 != null){
            flag = "success";
        }
        res.put("flag",flag);
        res.put("student",student1);
        String json = JSON.toJSONString(res);
//        System.out.println("最终传回前端页面的数据结果"+json);
        return json;
    }

    @ResponseBody
    @PostMapping("/teacherlogin")
    public String teacherlogin(@RequestBody Teacher teacher){
//        System.out.println(teacher);
        String flag = "error";
        Teacher teacher1 = loginMapper.getTeacherMessage(teacher.getTname(),teacher.getTpassword());
//        System.out.println("-----------------------");
//        System.out.println(teacher1);
        HashMap<String,Object> res = new HashMap<>();
        if(teacher1 != null){
            flag = "success";
        }
        res.put("flag",flag);
        res.put("teacher",teacher1);
        String json = JSON.toJSONString(res);
//        System.out.println("最终传回前端页面的数据结果"+json);
        return json;
    }


}
