package com.zut.mapper;

import com.zut.entity.Indexes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexMapper {
    List<Indexes> findAll(int index_type);

    List<Indexes> findAllIndex();

}
