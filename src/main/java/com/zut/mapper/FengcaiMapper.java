package com.zut.mapper;

import com.zut.entity.Fengcai;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FengcaiMapper {
    List<Fengcai> findALlFengCain();
    Fengcai findById(int id);
    void updateFengcai(Fengcai fengcai);
    void deleteById(int id);
    void addFengcai(Fengcai fengcai);
}
