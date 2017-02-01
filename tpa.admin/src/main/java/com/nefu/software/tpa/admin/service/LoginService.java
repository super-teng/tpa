package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.response.Result;

/**
 * 登录业务逻辑
 *
 * Created by Super腾 on 2017/1/22.
 */
public interface LoginService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果状态
     */
    public Result login(String username,String password);
}
