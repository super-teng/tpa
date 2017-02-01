package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.response.Result;

import java.util.List;

/**
 * 扶贫单位业务层
 * Created by Super腾 on 2017/1/29.
 */
public interface ReliefCompanyService {

    /**
     * 查询全部扶贫单位
     * @return
     */
    public Result selectAll();

    /**
     * 更新扶贫单位信息
     * @param reliefCompany
     * @return
     */
    public Result updateReliefCompany(ReliefCompany reliefCompany);

}
