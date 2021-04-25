package com.zut.mapper;

import com.zut.entity.Matostu;
import org.springframework.stereotype.Repository;

@Repository
public interface MatostuMapper {
    void answerContent(Matostu matostu);
}
