package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Manager;
import com.zut.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@ResponseBody
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerMapper managerMapper;

    @PostMapping("/managerlogin")
    public String login(String name,String password){
        String flag = "error";
//        System.out.println(name);
//        System.out.println(password);
        Manager manager = new Manager();
        manager.setName(name);
        manager.setPassword(password);
        Manager manager1 = managerMapper.managerlogin(manager);
        if(manager1 != null){
            flag = "success";
        }
//        System.out.println(manager1);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("manager",manager1);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
    @GetMapping("/findByName")
    public String findByName(String name){
        Manager byName = managerMapper.findByName(name);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag","success");
        hashMap.put("manager",byName);
        return JSON.toJSONString(hashMap);
    }



    @PostMapping("/updatePass")
    public String updatePass(@RequestBody JSONObject jsonObject){
//        System.out.println(jsonObject);
        Manager manager = jsonObject.toJavaObject(jsonObject, Manager.class);
//        System.out.println(manager);
        managerMapper.updatePass(manager);
        return "success";
    }

}
