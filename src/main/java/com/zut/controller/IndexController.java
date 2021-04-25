package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Indexes;
import com.zut.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/updateIndex")
    public String updateIndex(@RequestBody JSONObject jsonObject){
        Indexes indexes = jsonObject.toJavaObject(jsonObject, Indexes.class);
        indexMapper.updateIndexes(indexes);
        return "success";
    }

    @PostMapping("/insertIndex")
    public String updateIndex1(@RequestBody JSONObject jsonObject){
        Indexes indexes = jsonObject.toJavaObject(jsonObject, Indexes.class);
        indexMapper.insertIndex(indexes);
        return "success";
    }
    @GetMapping("/deleteIndexById")
    public String deleteIndex(int index_id){
        System.out.println(index_id);
        indexMapper.deleteIndex(index_id);
        return "success";
    }

}
