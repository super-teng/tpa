package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.response.Result;

/**
 * 扶贫计划业务层
 * Created by Super腾 on 2017/1/31.
 */
public interface PlanService {

    /**
     * 通过用户ID和标记来查询所拥有的的扶贫项目
     * @param reliefId
     * @return
     */
    public Result searchByUserIdAndFlag(Integer reliefId);
}
