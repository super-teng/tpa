package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.Production;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 扶贫项目DAO层
 *
 * Created by Super腾 on 2017/1/25.
 */
@Repository
public interface ProductionDao {
    /**
     * 插入一条扶贫项目数据
     * @param production 扶贫项目包装类
     */
    public void insertProduction(Production production);

    /**
     * 查看当前登录用户是否提交过扶贫项目通过ID来进行查询
     * @param id 登录用户的ID
     * @return  扶贫项目类
     */
    public Production searchByUserId(Integer id);

    /**
     * 更新扶贫项目信息
     *
     * @param production  扶贫项目
     */
    public void updateProduction(Production production);

    /**
     * 查询全部项目
     * @return
     */
    public List<Production> selectAll();

    /**
     * 更新项目通过
     * @param production 项目包装类
     */
    public void updatePass(Production production);

    /**
     * 通过扶贫用户ID和标记来查询当前所拥有的扶贫项目
     * @param userId
     * @param flag
     * @return
     */
    public Production searchProduction(@Param("userId") Integer userId , @Param("flag") String flag);


    /**
     * 删除扶贫项目
     * @param rid
     */
    public void deleteProduction(Integer rid);

}
