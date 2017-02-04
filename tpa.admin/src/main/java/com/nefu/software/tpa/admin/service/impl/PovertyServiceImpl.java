package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.PovertyService;
import com.nefu.software.tpa.dao.PovertyDao;
import com.nefu.software.tpa.entity.entity.Poverty;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 贫困用户业务层
 * Created by Super腾 on 2017/1/28.
 */
@Service
public class PovertyServiceImpl implements PovertyService {

    private static Logger logger = LoggerFactory.getLogger(PovertyServiceImpl.class);

    @Autowired
    public PovertyDao povertyDao;
    /**
     * 查询全部贫困用户
     * @return 结果集
     */
    public Result searchAllPoverty() {
        Result result = new Result();
        List<Poverty> list;
        try{
            list = povertyDao.selectAll();
        }catch (Exception e){
            logger.error("贫困个人dao层出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setObject(list);
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 更新贫困个人信息
     * @param poverty 贫困个人信息
     * @return 包装类
     */
    public Result updatePoverty(Poverty poverty) {
        Result result = new Result();
        try{
            povertyDao.updatePoverty(poverty);
        }catch (Exception e){
            logger.error("贫困个人DAO出现错误!");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 新增贫困个人信息
     * @param poverty 贫困个人信息
     * @return 包装类
     */
    public Result insertPoverty(Poverty poverty) {
        Result result = new Result();
        try{
            povertyDao.insertPoverty(poverty);
        }catch (Exception e){
            logger.error("贫困个人insertPoverty出现错误!");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 删除扶贫个人
     * @param id
     * @return
     */
    public Result deletePoverty(Integer id) {
        Result result = new Result();
        try{
            povertyDao.deletePoverty(id);
        }catch (Exception e){
            logger.error("贫困个人deletePoverty出现错误");
            e.printStackTrace();
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
