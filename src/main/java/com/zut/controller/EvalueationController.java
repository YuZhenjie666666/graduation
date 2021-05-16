package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Evalueation;
import com.zut.mapper.EvalueationMapper;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/evalueation")
@ResponseBody
public class EvalueationController {
    @Autowired
    EvalueationMapper evalueationMapper;

    @PostMapping("/toEvalueation")
    public String toEvalueation(@RequestBody JSONObject jsonObject){
        System.out.println("这是评价的信息");
        System.out.println(jsonObject);
        Evalueation evalueation = jsonObject.toJavaObject(jsonObject, Evalueation.class);
        System.out.println("这是转换成的java对象"+evalueation);
        evalueationMapper.postEvalueation(evalueation);
        return "success";
    }

    @GetMapping("/findAllTeacher")
    public String findallteachername(){
        List<String> allTeachername = evalueationMapper.findAllTeachername();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("allTeachername",allTeachername);
        String json = JSONObject.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/getscorebytname")
    public String getScore(String tname){
        List<Integer> aLlScoreByTeachername = evalueationMapper.findALlScoreByTeachername(tname);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("aLlScoreByTeachername",aLlScoreByTeachername);
        String json = JSONObject.toJSONString(hashMap);
        return json;
    }
    //    查询所有的平均分
    @GetMapping("/getSumScoreAverag")
    public String findAverage(){
        int allscoer = evalueationMapper.allscoer();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("average",allscoer);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

}
