package com.zut.mapper;

import com.zut.entity.Dailyweek;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyweekMapper {
    void insertDailyweek(Dailyweek dailyweek);
    void updateDaily(Dailyweek dailyweek);
    Dailyweek selectDaily(Dailyweek dailyweek);

    List<Dailyweek> selectAllByTeacher(String tname);

    List<Dailyweek> findAllnumber(Dailyweek dailyweek);
}
