package com.zut.mapper;

import com.zut.entity.TeachInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacInfoMapper {
    List<TeachInfo> findAllTeachInfo();
    TeachInfo findById(int id);
}
