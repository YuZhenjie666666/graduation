package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Fengcai;
import com.zut.mapper.FengcaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/fengcai")
public class FengcaiController {
    @Autowired
    FengcaiMapper fengcaiMapper;

    @GetMapping("/findall")
    public String findAll(){
        List<Fengcai> fengCain = fengcaiMapper.findALlFengCain();
        String flag = "error";
        if(fengCain != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("fengcai",fengCain);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
    @GetMapping("/findById")
    public String findAll1(int id){
        Fengcai fengCain = fengcaiMapper.findById(id);
        String flag = "error";
        if(fengCain != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("fengcai",fengCain);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

}
