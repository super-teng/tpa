package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 扶贫单位
 *
 * Created by Super腾 on 2017/1/19.
 */
@Repository
public interface ReliefCompanyDao {
    /**
     * 通过用户名密码来进行验证
     *
     * @param reliefCompany 保存用户名密码的包装类
     * @return  查询结果信息
     */
    public ReliefCompany searchByUAndP(ReliefCompany reliefCompany);

    /**
     * 插入一条公司信息
     * @param reliefCompany 公司包装类
     */
    public void insertOneCompany(ReliefCompany reliefCompany);

    /**
     * 更新公司信息
     * @param reliefCompany 公司包装类
     */
    public void updateInformation(ReliefCompany reliefCompany);

    /**
     * 查询全部的扶贫单位信息
     * @return
     */
    public List<ReliefCompany> selectAll();
}
