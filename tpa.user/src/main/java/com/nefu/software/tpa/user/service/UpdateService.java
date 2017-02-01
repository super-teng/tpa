package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 更新的业务层
 *
 * Created by Super腾 on 2017/1/24.
 */
public interface UpdateService {

    /**
     * 扶贫个人信息更新
     *
     * @param reliefPerson
     * @return
     */
    public Result reliefPersonUpdate(ReliefPerson reliefPerson);

    /**
     * 扶贫单位信息更新
     *
     * @param reliefCompany
     * @return
     */
    public Result reliefCompanyUpdate(ReliefCompany reliefCompany);
}
