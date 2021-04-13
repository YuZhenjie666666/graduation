package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Manager;
import com.zut.mapper.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.println(name);
        System.out.println(password);
        Manager manager = new Manager();
        manager.setName(name);
        manager.setPassword(password);
        Manager manager1 = managerMapper.managerlogin(manager);
        if(manager1 != null){
            flag = "success";
        }
        System.out.println(manager1);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("manager",manager1);
        String json = JSON.toJSONString(hashMap);
        return json;
    }
}
