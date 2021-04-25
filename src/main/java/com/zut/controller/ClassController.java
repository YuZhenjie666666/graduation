package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.MClass;
import com.zut.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findByidClass")
    public String findById(int id){
        MClass byId = classMapper.findById(id);
        String flag = "error";
        if(byId != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("class",byId);
        String json = JSON.toJSONString(hashMap);
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

//    管理员内容
    @GetMapping("/deleteClass")
    public String delete(int id){
        classMapper.deleteClass(id);
        return  "success";
    }

    @PostMapping("/updateClass")
    public String update(@RequestBody JSONObject jsonObject){
        MClass mClass = jsonObject.toJavaObject(jsonObject, MClass.class);
        classMapper.updateClass(mClass);
        return "success";
    }

    @PostMapping("/addClass")
    public String addClass(@RequestBody JSONObject jsonObject){
        MClass mClass = jsonObject.toJavaObject(jsonObject, MClass.class);
        classMapper.addClass(mClass);
        return "success";
    }
}
