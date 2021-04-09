package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    int f_number;
    int sid;
    String fclass;
    String tname;
    String f_week;
    String f_suggestion;
    String f_other;
    int tid;
}
