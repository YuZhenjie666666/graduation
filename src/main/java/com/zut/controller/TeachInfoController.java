package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.TeachInfo;
import com.zut.mapper.TeacInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/teachinfo")
public class TeachInfoController {
    @Autowired
    TeacInfoMapper teacInfoMapper;

    @GetMapping("/allteachinfo")
    public String findAll(){
        List<TeachInfo> list = teacInfoMapper.findAllTeachInfo();
        String flag = "error";
        if(list != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teachinfo",list);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

    @GetMapping("/findById")
    public String findById(int id){
        TeachInfo teachInfo = teacInfoMapper.findById(id);
        String flag = "error";
        if(teachInfo != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("teachinfo",teachInfo);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }
//    删除月报
    @GetMapping("/deleyuebaoById")
    public String deleteyuebao(int id){
        teacInfoMapper.deleteById(id);
        return "success";
    }
//    修改月报
    @PostMapping("/updateyuebao")
    public String updateyuebao(@RequestBody JSONObject jsonObject){
        TeachInfo teachInfo = jsonObject.toJavaObject(jsonObject, TeachInfo.class);
        teacInfoMapper.updatePingdu(teachInfo);
        return "success";
    }
//    添加月报
    @PostMapping("/addyuebao")
    public String addYuebao(@RequestBody JSONObject jsonObject){
        TeachInfo teachInfo = jsonObject.toJavaObject(jsonObject, TeachInfo.class);
        teacInfoMapper.addYuebao(teachInfo);
        return "success";
    }
}
