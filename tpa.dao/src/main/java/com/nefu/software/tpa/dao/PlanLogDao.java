package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.PlanLog;
import org.springframework.stereotype.Repository;

/**
 * 扶贫日志
 * Created by Super腾 on 2017/2/1.
 */
@Repository
public interface PlanLogDao {

    /**
     * 插入扶贫计划日志
     * @param planLog
     */
    public void insertPlanLog(PlanLog planLog);

    /**
     * 删除扶贫计划日志
     * @param lid
     */
    public void deletePlanLog(Integer lid);

}
