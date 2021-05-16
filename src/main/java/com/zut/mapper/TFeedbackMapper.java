package com.zut.mapper;

import com.zut.entity.TFeedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TFeedbackMapper {
    void postTFeedback(TFeedback tFeedback);
    List<TFeedback> findAllinfo(int tid);
    TFeedback findByOther(String teacher);

//    判断是否在7天内
    TFeedback findInsevenDay();
    TFeedback findInsevenDayS();

    void updateTfeedback(TFeedback tFeedback);

//    学生评价（首先查询该学生是否在班级内，并且评价信息为未评价）
//    查询学生的班级信息(根据学生的id)
    String findStudentClassInfo(int sid);
//    根据班级信息查询是否可以评价
    TFeedback findTFeedbackInfo(String sclass);
    int selectByteacnameSumscore(String tname);
//    查询全校教师的平均分
    int selectAverageScore();
}
