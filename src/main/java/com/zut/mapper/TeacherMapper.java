package com.zut.mapper;

import com.zut.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherMapper {
    List<Teacher> findAllTeacher();
    Teacher findTeacherByName(String tname);
    Teacher findByNumber(int tnumber);
    Teacher findById(int tid);
    void saveTeacherInfo(Teacher teacher);
    //根据id更改个人信息页面
    void updateFrofile(Teacher teacher);

    Teacher findAllInByNumber(int tnumber);
//    manager管理教师信息
//    void addTeacher(Teacher teacher);
//根据教师号删除教师信息
    void deleteTeacher(int tnumber);
//修改教师信息密码
    void updatePassword(Teacher teacher);

}
