package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.MClass;
import com.zut.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassMapper classMapper;

    @GetMapping("/findAll")
    public String findAll(){
        List<MClass> list = classMapper.findAll();
        String flag = "error";
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("mclasses",list);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }

    @GetMapping("/findByname")
    public String findByClassName(String classname){
        System.out.println(classname);
        MClass class1 = classMapper.findByClassName(classname);
        System.out.println(class1);
        String flag = "error";
        if(class1 != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("mclass",class1);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }
    // 查询所有的班级名称
    @GetMapping("/findAllClassname")
    public String findAllClassName(){
        List<MClass> allClassName = classMapper.findAllClassName();
        String flag = "error";
        if(allClassName != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("classnames",allClassName);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }
}
