package com.zut.controller;

import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Matoteacher;
import com.zut.mapper.MatoteacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/liuyanteacher")
public class MatoTeacher {
    @Autowired
    MatoteacherMapper mapper;
    @PostMapping("/answertoteacher")
    public String sna(@RequestBody JSONObject jsonObject){
        Matoteacher matoteacher = jsonObject.toJavaObject(jsonObject, Matoteacher.class);
        mapper.answerliuyan(matoteacher);
        return "success";
    }
}
