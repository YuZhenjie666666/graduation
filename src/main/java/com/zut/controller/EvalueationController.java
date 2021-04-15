package com.zut.controller;

import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Evalueation;
import com.zut.mapper.EvalueationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
