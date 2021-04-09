package com.zut.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zut.entity.OpositeLiuyan;
import com.zut.mapper.OpositeLiuyanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
@RequestMapping("/tomanagerLiuyan")
public class OpositeLiuyanController {
    @Autowired
    OpositeLiuyanMapper opositeLiuyanMapper;

    @PostMapping("/info")
    @ResponseBody
    public void tomanagerLiuyan(@RequestBody JSONObject opositeLiuyan, HttpServletRequest request){
      //  OpositeLiuyan tab = JSON.parseObject(request.getParameter("tab"),OpositeLiuyan.class);
        OpositeLiuyan opositeLiuyan1 = JSON.toJavaObject(opositeLiuyan,OpositeLiuyan.class);
        System.out.println(opositeLiuyan1);
        opositeLiuyanMapper.toManagerLiuyan(opositeLiuyan1);

        System.out.println(opositeLiuyan);
        System.out.println("插入成功");
    }
//    public void tomanagerLiuyan( OpositeLiuyan opositeLiuyan, HttpServletRequest request){
//        //  OpositeLiuyan tab = JSON.parseObject(request.getParameter("tab"),OpositeLiuyan.class);
//        opositeLiuyanMapper.toManagerLiuyan(opositeLiuyan);
//
//        System.out.println(opositeLiuyan);
//        System.out.println("插入成功");
//    }
}
