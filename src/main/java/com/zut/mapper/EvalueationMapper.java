package com.zut.mapper;

import com.zut.entity.Evalueation;
import org.springframework.stereotype.Repository;

@Repository
public interface EvalueationMapper {
    void postEvalueation(Evalueation evalueation);
}
