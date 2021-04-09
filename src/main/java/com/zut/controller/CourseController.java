package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Course;
import com.zut.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/evaluation")
public class CourseController {
    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/getAllCourseInfo")
    public String finAll(){
        List<Course> list = courseMapper.findAllCourseInfo();
        String flag = "error";
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("courses",list);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }

    @RequestMapping("/getCourseInfoByName")
    public String findCourseByCourseName(String coursename){
        List<Course> list = courseMapper.findByCourseName(coursename);
        System.out.println(coursename);
        String flag = "error";
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("course",list);
        hashMap.put("flag",flag);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }
    @GetMapping("/getCourseInfoByTeacherName")
    public String findCourseInfoByTeacher(String tname){
        List<Course> list = courseMapper.findByTeacher(tname);
//        System.out.println(tname);
//        System.out.println(list);
        String flag = "error";
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("course",list);
        String json = JSON.toJSONString(hashMap);
        //  System.out.println(json);
        return json;
    }


    //查询所有的课程去除重复的课程名称
    @GetMapping("/findAllCourseName")
    public String findAllCourseName(){
        List<Course> allCourseNameExceptBoth = courseMapper.findAllCourseNameExceptBoth();
        String flag = "error";
        if(allCourseNameExceptBoth != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("coursenames",allCourseNameExceptBoth);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }

}
