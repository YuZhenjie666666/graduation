package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.News;
import com.zut.mapper.NewsMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/evaluation")
public class NewsController {
    @Autowired
    NewsMapper newsMapper;
    @GetMapping("/findallnews")
    public String findAll(){
        List<News> listnews =  newsMapper.findAllNews();
//        System.out.println(listnews);

        HashMap<String,Object> hashMap = new HashMap<>();
        String flag = "error";
        if(listnews != null){
            flag = "success";
        }
        hashMap.put("flag",flag);
        hashMap.put("news",listnews);
//        System.out.println(hashMap);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @GetMapping("/findbyid/{id}")
    public String findById(@PathVariable("id") int id){
        News news = newsMapper.findById(id);
//        System.out.println(news);
        HashMap<String,Object> hashMap = new HashMap<>();
        String flag = "error";
        if(news != null){
            flag = "success";
        }
        hashMap.put("flag",flag);
        hashMap.put("news",news);
        String json = JSON.toJSONString(hashMap);
//        System.out.println(json);
        return json;
    }

    @GetMapping("/delete")
    public String deleteById(int id){
        newsMapper.deleteById(id);
        return "success";
    }

    // 添加新闻页面
    @PostMapping("/addnews")
    public String addNews(@RequestBody JSONObject jsonObject){
        News news = jsonObject.toJavaObject(jsonObject, News.class);
        newsMapper.addNews(news);
        return "success";
    }

//    修改新闻页面
    @PostMapping("/updatenews")
    public String updatenews(@RequestBody JSONObject jsonObject){
        News news = jsonObject.toJavaObject(jsonObject, News.class);
        newsMapper.updateNews(news);
        return "success";
    }
}
