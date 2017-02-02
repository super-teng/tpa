package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.PlanDao;
import com.nefu.software.tpa.dao.ProductionDao;
import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.PlanService;
import org.apache.ibatis.executor.ReuseExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * 扶贫计划
 * Created by Super腾 on 2017/1/31.
 */
@Service
public class PlanServiceImpl implements PlanService {

    private static Logger logger = LoggerFactory.getLogger(PlanServiceImpl.class);

    @Autowired
    public PlanDao planDao;
    /**
     * 通过用户ID和标记来查询所拥有的的扶贫项目
     * @param reliefId
     * @return
     */
    public Result searchById(Integer reliefId) {
        Result result = new Result();
        Plan plan;
        try{
            plan = planDao.searchPlan(reliefId);
        }catch (Exception e){
            logger.error("扶贫计划DAO层出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        if(plan == null){
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }else{
            result.setResultStatus(ResultStatus.SUCCESSFUL);
            result.setObject(plan);
            return result;
        }
    }
}
