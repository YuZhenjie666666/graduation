package com.zut.mapper;

import com.zut.entity.TFeedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TFeedbackMapper {
    void postTFeedback(TFeedback tFeedback);
    List<TFeedback> findAllinfo(int tid);
}
