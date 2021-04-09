package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachInfo {
    int id;
    String title;
    String content;
    String time;
    int liulan;
    String img;
}
