package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.ReliefPerson;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 扶贫个人
 *
 * Created by Super腾 on 2017/1/19.
 */
@Repository
public interface ReliefPersonDao {

    /**
     * 通过用户名和密码来进行查询操作
     *
     * @param reliefPerson 传入用户名密码的包装类
     * @return 查询结果信息
     */
    public ReliefPerson selectByUAndP(ReliefPerson reliefPerson);

    /**
     * 查询全部扶贫个人的信息
     * @return
     */
    public List<ReliefPerson> selectAll();

    /**
     * 插入扶贫个人信息
     *
     * @param reliefPerson 包装类
     */
    public void insertOnePerson(ReliefPerson reliefPerson);

    /**
     * 更新扶贫个人信息
     *
     * @param reliefPerson
     */
    public void updateInformation(ReliefPerson reliefPerson);
}

