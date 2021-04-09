package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Liuyan {
    int id;
    int tnumber;
    String mtitle;
    String content;
    String mtime;
}
