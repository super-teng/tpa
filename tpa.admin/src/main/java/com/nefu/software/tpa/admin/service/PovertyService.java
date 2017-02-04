package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.Poverty;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 贫困用户的业务层
 *
 * Created by Super腾 on 2017/1/28.
 */
public interface PovertyService {

    /**
     * 查询全部贫困用户
     * @return 结果集
     */
    public Result searchAllPoverty();

    /**
     * 更新贫困个人信息
     * @param poverty 贫困个人信息
     * @return 包装类
     */
    public Result updatePoverty(Poverty poverty);

    /**
     * 新增贫困个人信息
     * @param poverty 贫困个人信息
     * @return 包装类
     */
    public Result insertPoverty(Poverty poverty);

}
