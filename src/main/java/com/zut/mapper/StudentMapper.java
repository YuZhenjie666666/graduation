package com.zut.mapper;

import com.zut.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    List<Student> findAll();
}
