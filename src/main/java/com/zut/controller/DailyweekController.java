package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.Dailyweek;
import com.zut.mapper.DailyweekMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/Dailyweek")
public class DailyweekController {
    @Autowired
    DailyweekMapper dailyweekMapper;

    @PostMapping("/adddailyWeek")
    public String insertInto(@RequestBody JSONObject jsonObject){
        Dailyweek dailyweek = jsonObject.toJavaObject(jsonObject, Dailyweek.class);
        dailyweekMapper.insertDailyweek(dailyweek);
        return "success";
    }

    @PostMapping("/updatedailyWeek")
    public String updates(@RequestBody JSONObject jsonObject){
        Dailyweek dailyweek = jsonObject.toJavaObject(jsonObject, Dailyweek.class);
        dailyweekMapper.updateDaily(dailyweek);
        return "success";
    }

    @PostMapping("/selectteacherdaily")
    public String selecttea(@RequestBody JSONObject jsonObject){
        Dailyweek dailyweek = jsonObject.toJavaObject(jsonObject, Dailyweek.class);
        Dailyweek dailyweek1 = dailyweekMapper.selectDaily(dailyweek);
//        System.out.println("1111111");
//        System.out.println(dailyweek1);
        String flag = "error";
        if(dailyweek1 != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("dailyweek",dailyweek1);
        hashMap.put("flag",flag);
//        System.out.println(hashMap);
        return JSONObject.toJSONString(hashMap);
    }

//    教师端查询所有的评价信息，此内容不用经过管理员端
    @GetMapping("/findAllByTeachername")
    public String fidnaLL(String tanme){
        String flag = "error";
        List<Dailyweek> dailyweeks = dailyweekMapper.selectAllByTeacher(tanme);
        if(dailyweeks != null){
            flag = "success";
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("flag",flag);
        hashMap.put("dailyweeks",dailyweeks);
        String json = JSON.toJSONString(hashMap);
        return json;
    }

    @PostMapping("/findALlnumberByteacher")
    public String findALlnumberByteacher(@RequestBody JSONObject jsonObject){
        System.out.println("111111111111111111111111");
        System.out.println(jsonObject);
        Dailyweek dailyweek = jsonObject.toJavaObject(jsonObject, Dailyweek.class);
        List<Dailyweek> allnumber = dailyweekMapper.findAllnumber(dailyweek);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("allnumber",allnumber);
        String json = JSON.toJSONString(hashMap);
        System.out.println(json);
        return json;
    }

}
