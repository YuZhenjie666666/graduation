package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Student;
import com.zut.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping("/studentlogin")
    public String login(@RequestBody Student student){
        System.out.println(student);
        Student student1 = studentMapper.login(student);
        String flag = "error";
        if(student1 != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("student",student1);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @GetMapping("/findStudentById")
    public String findStudentById(int sid){
        System.out.println(sid);
        Student student = studentMapper.findStudentById(sid);
        System.out.println(student);
        String flag = "error";
        if(student != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("student",student);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @PostMapping("/editStudentInfo")
    public String editStudentInfo(@RequestBody JSONObject student){
        System.out.println(student);
        Student student1 = JSON.toJavaObject(student,Student.class);
        System.out.println(student1);
        studentMapper.saveInfo(student1);
        return "success";
    }

    @GetMapping("/getAlldepartment")
    public String findAll(){
        List<Student> aLlDepartment = studentMapper.findALlDepartment();
        String flag = "error";
        if(aLlDepartment != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("aLlDepartment",aLlDepartment);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
    //updatepassword
    @PostMapping("/updatepassword")
    public String updatePassword(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        Student student = jsonObject.toJavaObject(jsonObject, Student.class);
        System.out.println(student);
        studentMapper.updatestudentPassword(student);
        return "success";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody JSONObject jsonObject) {
        Student student = jsonObject.toJavaObject(jsonObject, Student.class);
        studentMapper.addStudent(student);
        return "success";
    }
//???????????????????????????
    @PostMapping("/managerUpdateStudent")
    public String update(@RequestBody JSONObject jsonObject){
        Student student = jsonObject.toJavaObject(jsonObject, Student.class);
        studentMapper.updateStudent(student);
        return "success";
    }
//    ???????????????????????????
    @GetMapping("/deleteStudent")
    public String delate(int sid){
        studentMapper.deleteStudent(sid);
        return "success";
    }
}