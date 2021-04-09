package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.zut.entity.Indexes;
import com.zut.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/index")
public class IndexController {
    @Autowired
    IndexMapper indexMapper;

    @GetMapping("/findByType")
    public String findAllByType(int index_type){
        List<Indexes> all = indexMapper.findAll(index_type);
        String flag = "error";
        HashMap<String,Object> hash = new HashMap<>();
        if(all != null){
            flag = "success";
        }
        hash.put("flag",flag);
        hash.put("indexes",all);
        String json = JSON.toJSONString(hash);
        return json;
    }

    @GetMapping("/findALl")
    public String findAll(){
        List<Indexes> all = indexMapper.findAllIndex();
        String flag = "error";
        HashMap<String,Object> hash = new HashMap<>();
        if(all != null){
            flag = "success";
        }
        hash.put("flag",flag);
        hash.put("indexes",all);
        String json = JSON.toJSONString(hash);
        return json;
    }


}
