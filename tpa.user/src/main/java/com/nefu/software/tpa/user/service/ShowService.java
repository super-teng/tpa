package com.nefu.software.tpa.user.service;

import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;

/**
 * 显示全部贫困人员信息
 *
 * Created by Super腾 on 2017/1/24.
 */
public interface ShowService {

    /**
     * 查询全部扶贫个人信息
     * @return
     */
    public Result showPoverty();

    /**
     * 查询全部自然村信息
     * @return
     */
    public Result showVillage();

}
