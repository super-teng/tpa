package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.PR;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 查找全部的扶贫结对信息
     * @return
     */
    public List<PR> selectAll();

    /**
     * 删除扶贫结对信息
     * @param planId
     */
    public void deletePR(Integer planId);
}
