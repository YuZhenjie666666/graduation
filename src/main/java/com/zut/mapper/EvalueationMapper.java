package com.zut.mapper;

import com.zut.entity.Evalueation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvalueationMapper {
    void postEvalueation(Evalueation evalueation);
//    查询所有教师
    List<String> findAllTeachername();
//    根据教师姓名查询教师分数（这个是学生给教师打的分数）（总评）
    List<Integer> findALlScoreByTeachername(String tname);
//    全部的平均分
    int allscoer();
}
