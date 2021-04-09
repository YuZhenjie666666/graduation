package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.TFeedback;
import com.zut.mapper.TFeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/tfeedback")
public class TFeedbackMapperController {
    @Autowired
    TFeedbackMapper tFeedbackMapper;

    @PostMapping("/detail")
    public void postTeacher(@RequestBody JSONObject tFeedback){
        System.out.println(tFeedback);
        TFeedback tFeedback1 = JSONObject.toJavaObject(tFeedback, TFeedback.class);
        tFeedbackMapper.postTFeedback(tFeedback1);
        System.out.println(tFeedback1);
        System.out.println("success");

    }


    @GetMapping("/findInfoByTid")
    public String findAllFeedback(int tid){
        List<TFeedback> allinfo = tFeedbackMapper.findAllinfo(tid);
        String flag = "error";
        if(allinfo != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("tfeedbacks",allinfo);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }
}
