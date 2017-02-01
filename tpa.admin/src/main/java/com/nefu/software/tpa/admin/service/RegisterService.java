package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 注册业务逻辑
 *
 * Created by Super腾 on 2017/1/27.
 */
public interface RegisterService {

    /**
     * 管理员注册
     * @param admin 实体包装类
     * @return 页面部分路径
     */
    public Result registerAdmin(Admin admin);

}
