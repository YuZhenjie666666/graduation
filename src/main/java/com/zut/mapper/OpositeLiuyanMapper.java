package com.zut.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zut.entity.OpositeLiuyan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpositeLiuyanMapper {
    void toManagerLiuyan(OpositeLiuyan opositeLiuyan);
//    管理员端信息(学生信息)
    List<OpositeLiuyan> findStudentInfo();
    //    管理员端信息(教师信息)
    List<OpositeLiuyan> findTeacherInfo();
}
