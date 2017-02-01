package com.nefu.software.tpa.admin.service.impl;


import com.nefu.software.tpa.admin.service.UpdateService;
import com.nefu.software.tpa.dao.AdminDao;
import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super腾 on 2017/1/27.
 */
@Service
public class UpdateServiceImpl implements UpdateService {

    private static Logger logger = LoggerFactory.getLogger(UpdateServiceImpl.class);
    @Autowired
    public AdminDao adminDao;

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    public Result updateAdmin(Admin admin) {
        Result result = new Result();
        try{
            adminDao.updateAdmin(admin);
        }catch (Exception e){
            logger.error("admin更新DAO出现错误");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }
}
