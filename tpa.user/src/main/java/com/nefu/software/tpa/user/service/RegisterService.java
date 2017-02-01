package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.response.Result;

/**
 *注册
 * Created by Super腾 on 2017/1/23.
 */
public interface RegisterService {

    /**
     * 扶贫个人注册
     *
     * @param reliefPerson 包装类
     * @return  返回信息
     */
    public Result reliefPersonRegister(ReliefPerson reliefPerson);

    /**
     * 扶贫单位注册
     *
     * @param reliefCompany 包装类
     * @return 返回信息
     */
    public Result reliefCompanyRegister(ReliefCompany reliefCompany);
}
