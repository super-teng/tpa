package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.PovertyDao;
import com.nefu.software.tpa.dao.VillageDao;
import com.nefu.software.tpa.entity.entity.Poverty;
import com.nefu.software.tpa.entity.entity.Village;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.ShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 显示全部扶贫人员信息
 *
 * Created by Super腾 on 2017/1/24.
 */
@Service
public class ShowServiceImpl implements ShowService {

    private static Logger logger = LoggerFactory.getLogger(ShowServiceImpl.class);

    @Autowired
    public PovertyDao povertyDao;

    @Autowired
    public VillageDao villageDao;

    /**
     * 查询全部扶贫个人信息
     * @return 分页的包装类
     */
    public Result showPoverty() {
        Result result = new Result();
        List<Poverty> list;
        try {
            //查询全部贫困个人
             list = povertyDao.selectAll();
        }catch (Exception e){
            logger.error("扶贫个人查询全部信息DAO时出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        //如果查询成功返回数据
        result.setObject(list);
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 查询全部自然村信息
     * @return
     */
    public Result showVillage() {
        Result result = new Result();
        List<Village> list;
        try{
            //查询全部自然村信息
            list = villageDao.selectAll();
        }catch (Exception e){
            //出现错误进行记录
            logger.error("自然村DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        //没有错误进行正常返回
        result.setObject(list);
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
