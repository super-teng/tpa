package com.nefu.software.tpa.admin.service;

import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.response.Result;

/**
 * Created by Super腾 on 2017/1/27.
 */
public interface UpdateService {

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    public Result updateAdmin(Admin admin);

}
