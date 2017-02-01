package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.ReliefCompanyDao;
import com.nefu.software.tpa.dao.ReliefPersonDao;
import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.UpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑层
 *
 * Created by Super腾 on 2017/1/24.
 */
@Service
public class UpdateServiceImpl implements UpdateService {

    private static Logger logger = LoggerFactory.getLogger(UpdateServiceImpl.class);

    @Autowired
    public ReliefPersonDao reliefPersonDao;

    @Autowired
    public ReliefCompanyDao reliefCompanyDao;

    /**
     * 扶贫个人信息更新
     *
     * @param reliefPerson  扶贫个人
     * @return 结果信息
     */
    public Result reliefPersonUpdate(ReliefPerson reliefPerson) {
        Result result = new Result();
        try {
            //调用DAO操作
            reliefPersonDao.updateInformation(reliefPerson);
            //如果DAO层出现错误
        }catch (Exception e){
            logger.error("reliefPerson Dao 层出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 扶贫单位信息更新
     *
     * @param reliefCompany
     * @return
     */
    public Result reliefCompanyUpdate(ReliefCompany reliefCompany) {
        Result result = new Result();
        try{
            //调用DAO方法
            reliefCompanyDao.updateInformation(reliefCompany);
        }catch(Exception e){
            //如果出现错误
            logger.error("单位更新DAO层出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

}
