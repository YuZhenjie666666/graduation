package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matostu {
    int id;
    int snumber;
    String beforequestion;
    String answer;
    String time;
}
