package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.Village;
import com.nefu.software.tpa.entity.response.Result;

/**
 * 自然村业务层
 * Created by Super腾 on 2017/1/29.
 */
public interface VillageService {

    /**
     * 显示全部自然村信息
     * @return
     */
    public Result selectAll();

    /**
     * 更新自然村信息
     * @param village 自然村包装咧
     * @return 部分页面地址
     */
    public Result updateVillage(Village village);

}
