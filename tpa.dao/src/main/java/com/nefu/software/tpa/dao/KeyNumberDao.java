package com.nefu.software.tpa.dao;

import com.nefu.software.tpa.entity.entity.KeyNumber;
import org.springframework.stereotype.Repository;

/**
 * 秘钥的DAO
 *
 * Created by Super腾 on 2017/1/27.
 */
@Repository
public interface KeyNumberDao {

    /**
     * 查询当前秘钥是否存在
     * @param keyNumber
     * @return
     */
    public KeyNumber searchByCandP(KeyNumber keyNumber);

}
