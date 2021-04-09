package com.zut.mapper;

import com.zut.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> findAllCourseInfo();
    List<Course> findByCourseName(String coursename);
    List<Course> findByTeacher(String tname);
    List<Course> findAllCourseNameExceptBoth();
}
