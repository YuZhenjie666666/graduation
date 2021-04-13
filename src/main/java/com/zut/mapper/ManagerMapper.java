package com.zut.mapper;

import com.zut.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {
   Manager managerlogin(Manager manager);

   Manager findById(int id);
}
