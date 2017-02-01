package com.nefu.software.tpa.admin.service.impl;


import com.nefu.software.tpa.admin.service.RegisterService;
import com.nefu.software.tpa.dao.AdminDao;
import com.nefu.software.tpa.dao.KeyNumberDao;
import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.entity.KeyNumber;
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
public class RegisterServiceImpl implements RegisterService {

    private static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
    @Autowired
    public AdminDao adminDao;

    @Autowired
    public KeyNumberDao keyNumberDao;



    /**
     * 管理员注册
     * @param admin 实体包装类
     * @return 页面部分路径
     */
    public Result registerAdmin(Admin admin) {
        Result result = new Result();
        KeyNumber keyNumber = new KeyNumber();
        keyNumber.setCompany(admin.getCompany());
        keyNumber.setPasskey(admin.getPasskey());
        //判断当前秘钥是否正确
        KeyNumber searchResult = keyNumberDao.searchByCandP(keyNumber);
        if(searchResult == null){
            //如果秘钥不正确返回
            logger.error("管理员秘钥不正确");
            result.setResultStatus(ResultStatus.FAILURE);
            return result;
        }else{
            //秘钥正确进行插入数据
            try {
                adminDao.insertOne(admin);
            }catch (Exception e){
                logger.error("管理员DAO出现错误！");
                result.setResultStatus(ResultStatus.FAILURE);
                return result;
            }
            result.setObject(admin);
            result.setResultStatus(ResultStatus.SUCCESSFUL);
            return result;
        }
    }
}
