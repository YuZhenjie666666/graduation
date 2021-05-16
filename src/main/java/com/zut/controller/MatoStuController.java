package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Matostu;
import com.zut.mapper.MatostuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/maanager")
public class MatoStuController {
    @Autowired
    MatostuMapper smapper;

    @PostMapping("/tostudentanswer")
    public String answer(@RequestBody JSONObject jsonObject){
        Matostu matostu = jsonObject.toJavaObject(jsonObject, Matostu.class);
        smapper.answerContent(matostu);
        return "success";
    }

    @GetMapping("/findAllmanageranswer")
    public String findAllmanageranswer(int snumber){
        List<Matostu> matostus = smapper.selectAnswer(snumber);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("matostus",matostus);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
}
