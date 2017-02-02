package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.ProductionDao;
import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.ProductionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super腾 on 2017/1/25.
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    private static Logger logger = LoggerFactory.getLogger(ProductionServiceImpl.class);

    @Autowired
    public ProductionDao productionDao;

    /**
     * 申请扶贫项目
     *
     * @param production 项目包装类
     * @return 结果包装类
     */
    public Result applyForProduction(Production production) {
        Result result = new Result();
        try{
            productionDao.insertProduction(production);
        }catch (Exception e){
            logger.error("扶贫项目DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 更新扶贫项目
     *
     * @param production 项目包装类
     * @return 结果包装类
     */
    public Result updateProduction(Production production) {
        Result result = new Result();
        try{
            productionDao.updateProduction(production);
        }catch (Exception e){
            logger.error("扶贫项目更新DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    public Production searchByRid(Integer id) {
        Production production = productionDao.searchByUserId(id);
        return production;
    }

    /**
     * 通过用户ID和标记来查询当前项目
     * @param userId 用户ID
     * @param flag 用户标记
     * @return
     */
    public Result searchByUserIdAndFlag(Integer userId,String flag) {
        Result result = new Result();
        Production production;
        try{
          production =  productionDao.searchProduction(userId,flag);
        }catch (Exception e){
            logger.error("扶贫项目searchByUserIdAndFlag DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setObject(production);
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
