package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.Village;

import java.util.List;

/**
 * 自然村
 *
 * Created by Super腾 on 2017/1/25.
 */
public interface VillageDao {

    /**
     * 查询全部自然村信息
     *
     * @return
     */
    public List<Village> selectAll();

    /**
     * 更新自然村信息
     * @param village 自然村包装类
     */
    public void updateVillage(Village village);

    /**
     * 插入自然村信息
     * @param village 自然村包装类
     */
    public void insertVillage(Village village);

}
