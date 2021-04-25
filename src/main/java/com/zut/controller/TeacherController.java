package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.OpositeLiuyan;
import com.zut.entity.Teacher;
import com.zut.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/evaluation")
public class TeacherController {
    @Autowired
    TeacherMapper teacherMapper;

    @GetMapping("/findAllTeacher")
    public List<Teacher> findAll(){
        return  teacherMapper.findAllTeacher();
    }

    @GetMapping("/findTeacherByName")
    public String findTeacherByName(String tname){
        Teacher teacher = teacherMapper.findTeacherByName(tname);
        String flag = "error";
        if(teacher != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teacher",teacher);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findByNumber")
    public String findByNumber(int tnumber){
        Teacher teacher = teacherMapper.findByNumber(tnumber);
        String flag = "error";
        if(teacher != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teacher",teacher);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findById")
    public Teacher findById(int tid){
        Teacher teacher = teacherMapper.findById(tid);
        System.out.println(teacher);
        if(teacher != null){
            return teacher;
        }
        return null;
    }

    @PostMapping("/editTeacherInfo")
    @ResponseBody
    public String saveTeacher(@RequestBody JSONObject teacher){
        System.out.println(teacher);
        Teacher teacher1 = JSON.toJavaObject(teacher,Teacher.class);
        teacherMapper.saveTeacherInfo(teacher1);
        List<Teacher> allTeacher = teacherMapper.findAllTeacher();
        System.out.println(allTeacher);
        return "success";
    }

    @PostMapping("/saveTeacherInfo")
    @ResponseBody
    public String saveTeacherinfo(@RequestBody JSONObject teacher){
        System.out.println(teacher);
        Teacher teacher1 = teacher.toJavaObject(teacher,Teacher.class);
        System.out.println(teacher1);
        teacherMapper.updateFrofile(teacher1);
//        List<Teacher> allTeacher = teacherMapper.findAllTeacher();
//        System.out.println(allTeacher);
        return "success";
    }

    @GetMapping("/deleteTeacherByTnumber")
    public String deleteTeacher(int tnumber){
        teacherMapper.deleteTeacher(tnumber);
        return "success";
    }

    @GetMapping("/findALlinfoByTnumber")
    public String find(int tnumber){
        String flag = "error";
        Teacher teacher = teacherMapper.findAllInByNumber(tnumber);
        if(teacher != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teacher",teacher);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
}
