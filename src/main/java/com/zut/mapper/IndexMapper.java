package com.zut.mapper;

import com.zut.entity.Indexes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexMapper {
    List<Indexes> findAll(int index_type);

    List<Indexes> findAllIndex();
    //添加指标内容
    void insertIndex(Indexes indexes);

    //    根据id进行删除
    void deleteIndex(int index_id);

    void updateIndexes(Indexes indexes);



}
