package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.ProductionService;
import com.nefu.software.tpa.dao.ProductionDao;
import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 扶贫项目业务层
 *
 * Created by Super腾 on 2017/1/30.
 */
@Service
public class ProductionServiceImpl implements ProductionService {

    private static Logger logger = LoggerFactory.getLogger(ProductionServiceImpl.class);

    @Autowired
    public ProductionDao productionDao;

    /**
     * 查询所有的扶贫项目
     * @return
     */
    public Result selectAll() {
        Result result = new Result();
        List<Production> list;
        try {
            list = productionDao.selectAll();
        }catch (Exception e){
            logger.error("扶贫项目dao层出现错误！");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        result.setObject(list);
        return result;
    }

    public Result passProduction(Production production) {
        Result result = new Result();
        try{
            productionDao.updatePass(production);
        }catch (Exception e){
            logger.error("通过扶贫项目passProduction出现错误");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 删除扶贫项目
     * @param rid
     * @return
     */
    public Result deleteProduction(Integer rid) {
        Result result = new Result();
        try{
            productionDao.deleteProduction(rid);
        }catch (Exception e){
            logger.error("扶贫项目deleteProduction出现错误");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
