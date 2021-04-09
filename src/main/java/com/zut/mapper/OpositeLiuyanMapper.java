package com.zut.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zut.entity.OpositeLiuyan;
import org.springframework.stereotype.Repository;

@Repository
public interface OpositeLiuyanMapper {
    void toManagerLiuyan(OpositeLiuyan opositeLiuyan);
}
