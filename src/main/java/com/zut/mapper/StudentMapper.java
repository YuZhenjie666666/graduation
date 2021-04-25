package com.zut.mapper;

import com.zut.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    List<Student> findAll();
    Student login(Student student);
    Student findStudentById(int sid);
    void saveInfo(Student student);
    List<Student> findALlDepartment();
//    添加学生信息
    void addStudent(Student student);

//    修改学生信息
    void updateStudent(Student student);
//    删除学生信息
    void deleteStudent(int sid);

}
