package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.entity.PlanLog;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 扶贫日志业务层
 * Created by Super腾 on 2017/2/1.
 */
public interface PlanLogService {

    /**
     * 插入扶贫日志
     * @param planLog
     * @return
     */
    public Result insertPlanLog(PlanLog planLog);

}
