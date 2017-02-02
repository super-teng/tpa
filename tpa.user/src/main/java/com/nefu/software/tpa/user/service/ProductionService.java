package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 扶贫项目业务层
 *
 * Created by Super腾 on 2017/1/25.
 */
public interface ProductionService {

    /**
     * 申请扶贫项目
     *
     * @param production 项目包装类
     * @return 结果包装类
     */
    public Result applyForProduction(Production production);

    /**
     * 更新扶贫项目
     *
     * @param production 项目包装类
     * @return 结果包装类
     */
    public Result updateProduction(Production production);

    /**
     * 通过ID来查询当前扶贫项目
     * @param id
     * @return
     */
    public Production searchByRid(Integer id);

    /**
     * 通过用户ID和标记来查询当前项目
     * @param userId 用户ID
     * @param flag 用户标记
     * @return
     */
    public Result searchByUserIdAndFlag(Integer userId,String flag);
}
