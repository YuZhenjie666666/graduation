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

    @GetMapping("/findNoEvauation")
    public String findaaa(String teacher){
        String flag = "error";
//        TFeedback tFeedback = jsonObject.toJavaObject(jsonObject, TFeedback.class);
        TFeedback byOther = tFeedbackMapper.findByOther(teacher);
        HashMap<String,Object> hashMap = new HashMap<>();
        if(byOther != null){
            flag = "success";
        }
        hashMap.put("flag",flag);
        hashMap.put("tFeedback",byOther);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findInSevenDay")
    public String inse(){
        TFeedback insevenDay = tFeedbackMapper.findInsevenDay();
        String flag = "error";
        if(insevenDay != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("tfeedback",insevenDay);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findInSevenDayS")
    public String inseA(){
        TFeedback insevenDay = tFeedbackMapper.findInsevenDayS();
        System.out.println("11111111111111111111111");
        System.out.println(insevenDay);
        String flag = "error";
        if(insevenDay != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("tfeedback",insevenDay);
        String json = JSON.toJSONString(hashMap);
        return json;
    }



    @PostMapping("/updateTfeedback")
    public String updateTfeedback(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject);
        TFeedback tFeedback = jsonObject.toJavaObject(jsonObject, TFeedback.class);
        System.out.println(tFeedback);
        tFeedbackMapper.updateTfeedback(tFeedback);
        return "success";
    }

    @GetMapping("/findStudengClass")
    public String findStudentClass(int sid){
        String studentClassInfo = tFeedbackMapper.findStudentClassInfo(sid);
        return studentClassInfo;
    }
    @GetMapping("/StudentfindTfeedbackInfo")
    public String StudentfindTfeedbackInfo(String sclass){
        TFeedback tFeedbackInfo = tFeedbackMapper.findTFeedbackInfo(sclass);
        HashMap<String,Object> hashMap = new HashMap<>();
        String flag = "error";
        if(tFeedbackInfo != null){
           flag = "success";
        }
        hashMap.put("flag",flag);
        hashMap.put("tFeedbackInfo",tFeedbackInfo);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findMyscoreterm")
    public String findtermscore(String tname){
        int i = tFeedbackMapper.selectByteacnameSumscore(tname);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("score",i);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/avgfindMyscoreterm")
    public String avgfindMyscoreterm(){
        int i = tFeedbackMapper.selectAverageScore();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("avgscore",i);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
}
