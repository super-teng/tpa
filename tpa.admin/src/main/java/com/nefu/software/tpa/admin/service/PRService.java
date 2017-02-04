package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.PR;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 帮扶结对
 *
 * Created by Super腾 on 2017/2/3.
 */
public interface PRService {

    /**
     * 插入扶贫结对类
     * @param pr
     * @return
     */
    public Result insertPR(PR pr);

    /**
     * 查找全部的扶贫结对类
     * @return
     */
    public Result selectAll();

    /**
     * 删除扶贫结对信息
     * @param planId
     * @return
     */
    public Result deletePR(Integer planId);



}
