package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * 管理员数据库操作Dao
 *
 * Created by Super腾 on 2017/1/22.
 */
@Repository
public interface AdminDao {
    /**
     * 通过用户名密码来进行查询的方法
     *
     * @param admin 管理员参数类
     * @return 返回查询信息
     */
    public Admin searchByUAndP(Admin admin);

    /**
     * 注册插入一条数据
     * @param admin 包装类
     */
    public void insertOne(Admin admin);


    /**
     * 更新管理员信息
     * @param admin 包装类
     */
    public void updateAdmin(Admin admin);
}
