package com.zut.mapper;

import com.zut.entity.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    List<Feedback> findAllFeedback(int tid);
    Feedback findByFnumber(int f_number);
    void postFeedback(Feedback feedback);
}
