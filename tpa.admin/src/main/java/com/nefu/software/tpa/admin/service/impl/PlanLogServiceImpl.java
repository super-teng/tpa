package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.PlanLogService;
import com.nefu.software.tpa.dao.PlanLogDao;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 扶贫日志
 * Created by Super腾 on 2017/2/4.
 */
@Service
public class PlanLogServiceImpl implements PlanLogService {

    private static Logger logger = LoggerFactory.getLogger(PlanLogServiceImpl.class);

    @Autowired
    public PlanLogDao planLogDao;

    /**
     * 删除扶贫日志
     * @param lid
     * @return
     */
    public Result deletePlanLog(Integer lid) {
        Result result = new Result();
        try{
            planLogDao.deletePlanLog(lid);
        }catch (Exception e){
            logger.error("扶贫日志deletePlanLog错误");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
