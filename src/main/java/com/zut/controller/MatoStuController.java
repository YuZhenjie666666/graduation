package com.zut.controller;

import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Matostu;
import com.zut.mapper.MatostuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
