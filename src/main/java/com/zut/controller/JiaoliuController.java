package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Jioaliu;
import com.zut.mapper.JioaliuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/jiaoliu")
public class JiaoliuController {
    @Autowired
    JioaliuMapper jioaliuMapper;

    @PostMapping("/addjiaoliu")
    public String addjiaoliu(@RequestBody JSONObject jsonObject){
        Jioaliu jioaliu = jsonObject.toJavaObject(jsonObject, Jioaliu.class);
        jioaliuMapper.addJioaliuinfo(jioaliu);
        return "success";
    }

    @GetMapping("/findBysname")
    public String findjiaoliu(String sname){
        List<Jioaliu> jioalius = jioaliuMapper.selectALl(sname);
        String flag = "error";
        if(jioalius != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("jiaoliu",jioalius);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
    @GetMapping("/findBytname")
    public String findjiaoliut(String monitor){
        List<Jioaliu> jioalius = jioaliuMapper.findByTname(monitor);
        String flag = "error";
        if(jioalius != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("jiaoliu",jioalius);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @PostMapping("/answerquestion")
    public String answerquestion(@RequestBody JSONObject jsonObject){
        System.out.println("0000000000000");
        System.out.println(jsonObject);
        Jioaliu jioaliu = jsonObject.toJavaObject(jsonObject, Jioaliu.class);
        jioaliuMapper.updateJiaoliu(jioaliu);
        return "success";
    }
}
