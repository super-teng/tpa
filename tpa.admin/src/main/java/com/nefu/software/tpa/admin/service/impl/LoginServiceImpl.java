package com.nefu.software.tpa.admin.service.impl;

import com.nefu.software.tpa.admin.service.LoginService;
import com.nefu.software.tpa.dao.AdminDao;
import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录
 *
 * Created by Super腾 on 2017/1/22.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    public AdminDao adminDao;
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果状态
     */
    public Result login(String username, String password) {
        Result result = new Result();
        //健壮性判断
        if(username != null && username != "" && password != null && password != ""){
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            Admin returnAdmin = adminDao.searchByUAndP(admin);
            //如果数据库中存在信息的话
            if(returnAdmin != null){
                result.setObject(returnAdmin);
                result.setResultStatus(ResultStatus.SUCCESSFUL);
                return result;
            }else{
                result.setResultStatus(ResultStatus.NOTFOUND);
                return result;
            }
            //如果用户参数不全的话
        }else{
            result.setResultStatus(ResultStatus.MISSING);
            return result;
        }
    }
}
