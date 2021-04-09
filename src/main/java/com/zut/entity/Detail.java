package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    int dnumber;
    int did;
    int sid;
    String dterm;
    String dclass;
    int tid;
    String tsumscore;


}
