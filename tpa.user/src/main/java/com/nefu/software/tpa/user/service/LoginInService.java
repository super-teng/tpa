package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.response.Result;
import org.springframework.stereotype.Service;

/**
 * 用户登录逻辑
 *
 * Created by Super腾 on 2017/1/19.
 */
@Service
public interface LoginInService {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param code 用户填写的验证码
     * @param sessionCode 真实的验证码
     * @param identity 身份（扶贫主体，扶贫单位）
     * @return 结果数据
     */
    public Result login(String username, String password, String code, String sessionCode, String identity);

    /**
     * 查询当前用户的扶贫项目
     *
     * @param id 用户ID
     * @return 返回包装类
     */
    public Result searchProduction(Integer id);
}
