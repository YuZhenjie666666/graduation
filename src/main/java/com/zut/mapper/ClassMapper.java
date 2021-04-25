package com.zut.mapper;

import com.zut.entity.MClass;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface ClassMapper {
    List<MClass> findAll();

    MClass findByClassName(@PathVariable("classname") String classname);

    List<MClass> findAllClassName();
    MClass findById(int id);

//    管理员内容
    void addClass(MClass mClass);
    void deleteClass(int id);
    void updateClass(MClass mClass);

}
