package com.zut.mapper;

import com.zut.entity.Jioaliu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JioaliuMapper {
    void addJioaliuinfo(Jioaliu jioaliu);
    List<Jioaliu> selectALl(String sname);
    List<Jioaliu> findByTname(String monitor);
    void updateJiaoliu(Jioaliu jioaliu);
}
