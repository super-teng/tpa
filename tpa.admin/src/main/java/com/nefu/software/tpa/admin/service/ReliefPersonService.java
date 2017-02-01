package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.response.Result;

import java.util.List;

/**
 * 扶贫个人业务层
 * Created by Super腾 on 2017/1/29.
 */
public interface ReliefPersonService {

    /**
     * 查询全部的扶贫个人
     * @return
     */
    public Result selectAll();

    /**
     * 更新扶贫个人信息
     * @param reliefPerson
     * @return
     */
    public Result updateReliefPerson(ReliefPerson reliefPerson);

}
