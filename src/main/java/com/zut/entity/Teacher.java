package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    int tnumber;
    int  tid;
    String ttype;
    String tname;
    String tsex;
    String tdepartment;
    String tmajor;
    String teducation;
    String ttitle;
    String tpassword;
    String temail;
    String tbirthday;
    String simpleinfo;
}
