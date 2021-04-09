package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MClass {
    int id;
    String classname;
    String monitor;
    String teacher;
    String cnumber;
    String major;
    String other;
}
