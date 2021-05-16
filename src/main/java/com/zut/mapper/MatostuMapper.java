package com.zut.mapper;

import com.zut.entity.Matostu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatostuMapper {
    void answerContent(Matostu matostu);
    List<Matostu>  selectAnswer(int snumber);
}
