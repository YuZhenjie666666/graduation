package com.zut.mapper;

import com.zut.entity.Matoteacher;
import org.springframework.stereotype.Repository;

@Repository
public interface MatoteacherMapper {
    void answerliuyan(Matoteacher matoteacher);
}
