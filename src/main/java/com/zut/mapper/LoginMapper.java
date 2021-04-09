package com.zut.mapper;

import com.zut.entity.Student;
import com.zut.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
    public Student getStudentMessage(@Param("sname")String sname,@Param("spassword") int spassword);
//    public Student getStudentMessage(Student student);
    public Teacher getTeacherMessage(@Param("tname")String tname,@Param("tpassword") String tpassword);
}
