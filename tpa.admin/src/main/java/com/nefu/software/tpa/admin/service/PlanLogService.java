package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.response.Result;

/**
 * Created by Super腾 on 2017/2/4.
 */
public interface PlanLogService {
    /**
     * 删除扶贫日志
     * @param lid
     * @return
     */
    public Result deletePlanLog(Integer lid);
}
