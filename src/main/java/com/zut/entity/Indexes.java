package com.zut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Indexes {
    int index_id;
    int index_number;
    int index_type;
    String index_name;
    int index_capacity;
}
