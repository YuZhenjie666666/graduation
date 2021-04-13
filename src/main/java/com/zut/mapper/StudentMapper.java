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
}
