package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 扶贫计划
 * Created by Super腾 on 2017/1/31.
 */
public interface PlanService {

    /**
     * 插入扶贫计划
     * @param plan
     * @return
     */
    public Result insertPlan(Plan plan);
}
