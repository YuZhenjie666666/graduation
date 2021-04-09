package com.zut.mapper;

import com.zut.entity.Liuyan;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LiuyanMapper {
    List<Liuyan> findAllLiuyanByTeacherNumber(int tnumber);
    Liuyan findById(int id);
}
