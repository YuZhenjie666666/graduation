package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Feedback;
import com.zut.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackMapper feedbackMapper;

    @GetMapping("/allfeedbackByTid")
    public String findAll(int tid){
        List<Feedback> feedbackList = feedbackMapper.findAllFeedback(tid);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("feedback",feedbackList);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @GetMapping("/findByNumber")
    public String findById(int f_number){
        Feedback feedback = feedbackMapper.findByFnumber(f_number);
        String flag = "error";
        if(feedback != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("feedback",feedback);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    //学生评价页面给管理员
    @PostMapping("/stomanager")
    public String stomanager(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        Feedback feedback = jsonObject.toJavaObject(jsonObject,Feedback.class);
        System.out.println(feedback);
        feedbackMapper.postFeedback(feedback);
        return "success";
    }

}
