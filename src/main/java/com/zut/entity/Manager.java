package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    int id;
    Date datetime;
    String info;
    String img;
    String birthday;
    String sex;
    String age;
    String phonenumber;
    String mail;
    String password;
    String name;
}
