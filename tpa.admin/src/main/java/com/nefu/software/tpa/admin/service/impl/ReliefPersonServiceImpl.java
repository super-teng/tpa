package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.ReliefPersonService;
import com.nefu.software.tpa.dao.ReliefPersonDao;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 扶贫个人业务层
 *
 * Created by Super腾 on 2017/1/29.
 */
@Service
public class ReliefPersonServiceImpl implements ReliefPersonService {

    private static Logger logger = LoggerFactory.getLogger(ReliefPersonServiceImpl.class);

    @Autowired
    public ReliefPersonDao reliefPersonDao;
    /**
     * 查询全部的扶贫个人
     * @return
     */
    public Result selectAll() {
        Result result = new Result();
        List<ReliefPerson> list;
        try {
            list = reliefPersonDao.selectAll();
        }catch (Exception e){
            logger.error("扶贫个人dao层出现错误！");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        result.setObject(list);
        return result;
    }

    /**
     * 更新扶贫个人信息
     * @param reliefPerson
     * @return
     */
    public Result updateReliefPerson(ReliefPerson reliefPerson) {
        Result result = new Result();
        try{
            reliefPersonDao.updateInformation(reliefPerson);
        }catch (Exception e){
            logger.error("扶贫个人DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
