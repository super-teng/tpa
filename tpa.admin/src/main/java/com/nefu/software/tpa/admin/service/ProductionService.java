package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.response.Result;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 扶贫项目业务层
 *
 * Created by Super腾 on 2017/1/29.
 */
public interface ProductionService {

    /**
     * 查询所有的扶贫项目
     * @return
     */
    public Result selectAll();

    /**
     * 通过扶贫项目
     * @param production 包装类
     * @return 部分页面路径
     */
    public Result passProduction(Production production);

    /**
     * 删除扶贫项目
     * @param rid
     * @return
     */
    public Result deleteProduction(Integer rid);


}
