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

import java.util.List;

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

    /**
     * 查询全部扶贫计划
     * @return
     */
    public Result searchAllPlan() {
        Result result = new Result();
        List<Plan> list;
        try{
           list = planDao.searchAll();
        }catch (Exception e){
            logger.error("查询全部扶贫计划出现错误");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return  result;
        }
        if(list == null){
            result.setResultStatus(ResultStatus.FAILURE);
            return  result;
        }else{
            result.setResultStatus(ResultStatus.SUCCESSFUL);
            result.setObject(list);
            return result;
        }
    }

    /**
     * 通过扶贫主体ID和标记来查询扶贫计划
     * @return
     */
    public Result searchPlanByIdAndFlag(Plan plan) {
        Result result = new Result();
        Plan returnPlan;
        try{
            returnPlan =  planDao.searchPlanByIdAndFlag(plan);
        }catch (Exception e){
            logger.error("扶贫计划searchPlanByIdAndFlag出现错误！");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setObject(returnPlan);
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 通过扶贫计划ID来查询扶贫计划
     * @param planId
     * @return
     */
    public Result searchById(Integer planId) {
        Result result = new Result();
        Plan plan;
        try{
            plan = planDao.searchPlanById(planId);
        }catch (Exception e){
            logger.error("扶贫计划searchById出现错误！");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        result.setObject(plan);
        return result;
    }
}
