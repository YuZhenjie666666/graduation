package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evalueation {
    int id;
    String sname;
    String tname;
    String coursename;
    String time;
    int score;
    String liuyan;
}
