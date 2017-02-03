package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.PRService;
import com.nefu.software.tpa.dao.PRDao;
import com.nefu.software.tpa.entity.entity.PR;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 帮扶结对业务层
 *
 * Created by Super腾 on 2017/2/3.
 */
@Service
public class PRServiceImpl implements PRService{


    private static Logger logger = LoggerFactory.getLogger(PRServiceImpl.class);

    @Autowired
    public PRDao prDao;
    /**
     * 插入扶贫结对类
     * @param pr
     * @return
     */
    public Result insertPR(PR pr) {
        logger.info("帮扶结对："+pr.toString());
        Result result = new Result();
        try{
            prDao.insertPR(pr);
        }catch (Exception e){
            logger.error("帮扶结对DAO出现错误!");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
