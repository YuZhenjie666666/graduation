package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dailyweek {
    int id;
    String tname;
    String coursename;
//    String index_id;
    String index_name;
    int good;
    int soso;
    int bad;
    String flag;
}
