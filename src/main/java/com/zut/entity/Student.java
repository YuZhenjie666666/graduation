package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int snumber;
    int sid;
    String sname;
    String ssex;
    String sdepartment;
    String sclass;
    int spassword;
}
