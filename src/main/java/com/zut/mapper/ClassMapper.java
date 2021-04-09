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
}
