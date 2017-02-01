package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.ReliefCompanyService;
import com.nefu.software.tpa.dao.ReliefCompanyDao;
import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 更新扶贫单位信息
 * Created by Super腾 on 2017/1/29.
 */
@Service
public class ReliefCompanyServiceImpl implements ReliefCompanyService {


    private static Logger logger = LoggerFactory.getLogger(ReliefCompanyServiceImpl.class);

    @Autowired
    public ReliefCompanyDao reliefCompanyDao;
    /**
     * 查询全部扶贫单位
     * @return
     */
    public Result selectAll() {
        Result result = new Result();
        List<ReliefCompany> list;
        try {
            list = reliefCompanyDao.selectAll();
        }catch (Exception e){
            logger.error("扶贫单位dao层出现错误！");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        result.setObject(list);
        return result;
    }

    /**
     * 更新扶贫单位信息
     * @param reliefCompany
     * @return
     */
    public Result updateReliefCompany(ReliefCompany reliefCompany) {
        Result result = new Result();
        try{
            reliefCompanyDao.updateInformation(reliefCompany);
        }catch (Exception e){
            logger.error("扶贫单位DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
