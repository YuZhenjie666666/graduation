package com.zut.mapper;

import com.zut.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NewsMapper {
    List<News> findAllNews();
    News findById(int id);
}
