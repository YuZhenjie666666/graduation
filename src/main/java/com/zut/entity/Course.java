package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    int id;
    String coursename;
    String tname;   //任课教师名称
    String cstudent;  //上课学生班级名称
    String ctime; //上课时间
    String chome;//上课地点
}
