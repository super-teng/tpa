package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.PlanService;
import com.nefu.software.tpa.dao.PlanDao;
import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super腾 on 2017/1/31.
 */
@Service
public class PlanServiceImpl implements PlanService {

    private static Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

    @Autowired
    public PlanDao planDao;

    /**
     * 插入扶贫计划
     * @param plan
     * @return
     */
    public Result insertPlan(Plan plan) {
        Result result = new Result();
        try{
            planDao.insertPlan(plan);
        }catch (Exception e){
            logger.error("扶贫计划DAO插入出现错误！");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
