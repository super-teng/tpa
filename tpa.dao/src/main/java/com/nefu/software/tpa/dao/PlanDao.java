package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.Production;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 扶贫计划DAO
 *
 * Created by Super腾 on 2017/1/31.
 */
@Repository
public interface PlanDao {


    /**
     * 通过扶贫用户ID来查询当前所拥有的扶贫计划
     * @param reliefId
     * @return
     */
    public Plan searchPlan(Integer reliefId);

    /**
     * 插入扶贫计划
     * @param plan
     */
    public void insertPlan(Plan plan);


}
