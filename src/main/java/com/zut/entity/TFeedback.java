package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFeedback {
    int id;
    int tnumber;
    int tid;
    String weektime;
    String coursename;
    String teachername;
    String teacher;
    String sclass;
    String liuyan;
    String other;
    int sumscore;
}
