package com.zut.mapper;

import com.zut.entity.TeachInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacInfoMapper {
    List<TeachInfo> findAllTeachInfo();
    TeachInfo findById(int id);

    //管理员端修改删除
    void deleteById(int id);
    //修改
    void updatePingdu(TeachInfo teachInfo);
    //添加月报
    void addYuebao(TeachInfo teachInfo);
}
