package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Score;
import com.zut.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreMapper scoreMapper;

    @GetMapping("/findAll")
    public String findAllScore(){
        String flag = "error";
        List<Score> scoreList = scoreMapper.findALlScoreInfo();
        if(scoreList != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("scorelist",scoreList);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    //最近一个月的
    @GetMapping("/resentMonth")
    public String findInOneMonth(){
        String flag = "error";
        List<Score> inOneMonth = scoreMapper.findInOneMonth();
        if(inOneMonth != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("monthscore",inOneMonth);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    //查询到现在的数据信息
    @GetMapping("/uptonow")
    public String finduptinow(String time){
        System.out.println(time);
        String flag = "error";
        List<Score> month = scoreMapper.findToNow(time);
        if(month != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("uptonow",month);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
}
