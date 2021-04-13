package com.zut.mapper;

import com.zut.entity.Course;
import com.zut.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> findAllCourseInfo();
    List<Course> findByCourseName(String coursename);
    List<Course> findByTeacher(String tname);
    List<Course> findAllCourseNameExceptBoth();
    //这里面是根据班级信息进行查询所有的课程信息
    List<Course> findByCstudent(String cstudent);

}
