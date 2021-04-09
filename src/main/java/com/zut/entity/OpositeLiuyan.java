package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpositeLiuyan {
//    这是给管理员留言信息
    int id;
    int snumber;
    int tnumber;
    String mail;
    String  time;
    String content;
}
