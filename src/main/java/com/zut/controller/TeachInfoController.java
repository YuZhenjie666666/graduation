package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.TeachInfo;
import com.zut.mapper.TeacInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/teachinfo")
public class TeachInfoController {
    @Autowired
    TeacInfoMapper teacInfoMapper;

    @GetMapping("/allteachinfo")
    public String findAll(){
        List<TeachInfo> list = teacInfoMapper.findAllTeachInfo();
        String flag = "error";
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teachinfo",list);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @GetMapping("/findById")
    public String findById(int id){
        TeachInfo teachInfo = teacInfoMapper.findById(id);
        String flag = "error";
        if(teachInfo != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teachinfo",teachInfo);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }
}
