package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Fengcai;
import com.zut.mapper.FengcaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/deleteById")
    public String deleteById(int id){
        fengcaiMapper.deleteById(id);
        return "success";
    }

    @PostMapping("/updateFengcai")
    public String updateFengcai(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        Fengcai fengcai = jsonObject.toJavaObject(jsonObject, Fengcai.class);
        System.out.println(fengcai);
        fengcaiMapper.updateFengcai(fengcai);
        return "success";
    }

    @PostMapping("/addFengcaiinfo")
    public String addFengcai(@RequestBody JSONObject jsonObject){
        Fengcai fengcai = jsonObject.toJavaObject(jsonObject, Fengcai.class);
        fengcaiMapper.addFengcai(fengcai);
        return "success";
    }

}
