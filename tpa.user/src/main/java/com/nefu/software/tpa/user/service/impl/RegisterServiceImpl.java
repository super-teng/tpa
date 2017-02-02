package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.ReliefCompanyDao;
import com.nefu.software.tpa.dao.ReliefPersonDao;
import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注册
 * Created by Super腾 on 2017/1/23.
 */
@Service
public class RegisterServiceImpl implements RegisterService  {
    private static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    public ReliefPersonDao reliefPersonDao;

    @Autowired
    public ReliefCompanyDao reliefCompanyDao;
    /**
     * 扶贫个人注册
     *
     * @param reliefPerson 包装类
     * @return Result 返回结果集
     */
    public Result reliefPersonRegister(ReliefPerson reliefPerson) {
        Result result = new Result();
//        try {
            reliefPersonDao.insertOnePerson(reliefPerson);
//        }catch (Exception e){
//            logger.error("reliefPerson Dao 层出现错误");
//            result.setResultStatus(ResultStatus.FAILURE);
//            return result;
//        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }

    /**
     * 扶贫单位注册
     *
     * @param reliefCompany 包装类
     * @return 返回信息
     */
    public Result reliefCompanyRegister(ReliefCompany reliefCompany) {
        Result result = new Result();
        try{
            reliefCompanyDao.insertOneCompany(reliefCompany);
        }catch (Exception e){
            logger.error("reliefCompany Dao 层出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
