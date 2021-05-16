package com.zut.mapper;

import com.zut.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScoreMapper {
    List<Score> findALlScoreInfo();
    //查询近一个月的信息
    List<Score> findInOneMonth();

    //查询某个时间到现在的内容
    List<Score> findToNow(String time);

//    判断是否在7天内

}
