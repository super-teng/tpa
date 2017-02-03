package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.PR;
import org.springframework.stereotype.Repository;

/**
 * 帮扶结对表
 *
 * Created by Super腾 on 2017/2/3.
 */
@Repository
public interface PRDao {

    /**
     * 插入一条扶贫结对数据
     * @param pr
     */
    public void insertPR(PR pr);

}
