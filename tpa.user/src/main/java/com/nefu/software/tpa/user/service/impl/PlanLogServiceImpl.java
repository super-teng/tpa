package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.PlanLogDao;
import com.nefu.software.tpa.entity.entity.PlanLog;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.PlanLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 扶贫日志业务层方法
 *
 * Created by Super腾 on 2017/2/1.
 */
@Service
public class PlanLogServiceImpl implements PlanLogService {

    private static Logger logger = LoggerFactory.getLogger(PlanLogServiceImpl.class);

    @Autowired
    public PlanLogDao planLogDao;

    /**
     * 插入扶贫日志
     * @param planLog
     * @return
     */
    public Result insertPlanLog(PlanLog planLog) {
        Result result = new Result();
        try{
            planLogDao.insertPlanLog(planLog);
        }catch (Exception e){
            logger.error("扶贫日志DAO层出现错误!");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
