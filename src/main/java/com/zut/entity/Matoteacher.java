package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matoteacher {
    int id;
    int tnumber;
    String beforequestion;

    String answer;
    String time;
    int flag;
}
