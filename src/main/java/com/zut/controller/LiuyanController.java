package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Liuyan;
import com.zut.mapper.LiuyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/liuyan")
public class LiuyanController {

    @Autowired
    LiuyanMapper liuyanMapper;

    @GetMapping("/findManagerFeedbackInfo")
    public String findAllManagerFeedBack(int tnumber){
        List<Liuyan> liuyan = liuyanMapper.findAllLiuyanByTeacherNumber(tnumber);
        String flag = "error";
        if(liuyan != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("managerliuyan",liuyan);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findbyId")
    public String findById(int id){
        Liuyan liuyan = liuyanMapper.findById(id);
        String json = JSON.toJSONString(liuyan);
        return json;
    }
}
