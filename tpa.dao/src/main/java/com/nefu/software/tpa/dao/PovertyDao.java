package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.Poverty;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 贫困个人
 *
 * Created by Super腾 on 2017/1/24.
 */
@Repository
public interface PovertyDao {
    /**
     * 查询全部贫困个人信息
     *
     * @return
     */
    public List<Poverty> selectAll();

    /**
     * 更新贫困个人信息
     * @param poverty
     */
    public void updatePoverty(Poverty poverty);

    /**
     * 添加贫困用户
     * @param poverty
     */
    public void insertPoverty(Poverty poverty);

}
