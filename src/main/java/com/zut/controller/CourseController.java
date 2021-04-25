package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Course;
import com.zut.entity.Student;
import com.zut.mapper.CourseMapper;
import com.zut.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/evaluation")
public class CourseController {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    StudentMapper studentMapper;

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
    public String findCourseInfoByTeacher(String tname,int sid){
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

    // 这个接口是根据上课班级进行查询所有的上课班级信息
    @GetMapping("/findAllCourseByClassname")
    public String findAllCourses(String cstudent,int sid){
        System.out.println("班级信息"+cstudent);
        System.out.println("学生的学号"+sid);
        String flag = "error";
        List<Course> list = courseMapper.findByCstudent(cstudent);
        Student student = studentMapper.findStudentById(sid);
        System.out.println(list);
        if(list != null  && student != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("courses",list);
        hashMap.put("student",student);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @GetMapping("/findCoursesMyself")
    public String findMyCourse(String coursename,String cstudent){
        List<Course> list = courseMapper.findByClassNameAndCourseName(coursename, cstudent);
        System.out.println(list);
        String flag = "error";
//        List<Course> list = courseMapper.findByCstudent(cstudent);
//        Student student = studentMapper.findStudentById(sid);
//        System.out.println(list);
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("courses",list);
//        hashMap.put("student",student);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @GetMapping("/deleteCourseById")
    public String deleteById(int id){
        courseMapper.deleteCourse(id);
        return "success";
    }

    @PostMapping("/addCourse")
    public String add(@RequestBody JSONObject jsonObject){
        Course course = jsonObject.toJavaObject(jsonObject, Course.class);
        courseMapper.addCourse(course);
        return "success";
    }

    @PostMapping("/updateCourse")
    public String update(@RequestBody JSONObject jsonObject){
        Course course = jsonObject.toJavaObject(jsonObject, Course.class);
        courseMapper.updateCourse(course);
        return "success";
    }

}
