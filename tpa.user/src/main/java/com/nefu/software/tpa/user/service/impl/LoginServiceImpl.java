package com.nefu.software.tpa.user.service.impl;

import com.nefu.software.tpa.dao.ProductionDao;
import com.nefu.software.tpa.dao.ReliefCompanyDao;
import com.nefu.software.tpa.dao.ReliefPersonDao;
import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.LoginInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录的实现类
 *
 * Created by Super腾 on 2017/1/19.
 */
@Service
public class LoginServiceImpl implements LoginInService{


    private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    //扶贫个人
    @Autowired
    public ReliefPersonDao reliefPersonDao;

    //扶贫单位
    @Autowired
    public ReliefCompanyDao reliefCompanyDao;

    //扶贫项目
    @Autowired
    public ProductionDao productionDao;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param code 用户填写的验证码
     * @param sessionCode 真实的验证码
     * @param identity 身份（扶贫主体，扶贫单位）
     * @return
     */
    public Result login(String username, String password, String code, String sessionCode, String identity) {
        //返回结果信息
        Result result = new Result();
        //健壮性判断
        if(username != null && username !="" && password != null && password != "" && code != null && code != "" && sessionCode != null && sessionCode != "" && identity != null && identity != ""){

            //验证码正确
            if(sessionCode.equals(code)){
                //扶贫个人
                if(identity.equals("扶贫个人")){
                    //查询当前用户名或密码是否正确
                    ReliefPerson reliefPerson = new ReliefPerson();
                    reliefPerson.setUsername(username);
                    reliefPerson.setPassword(password);
                    //调用DAO进行查询
                    ReliefPerson resultPerson = reliefPersonDao.selectByUAndP(reliefPerson);
                    //如果当前用户存在
                    if(resultPerson != null){
                        logger.info("after search: "+ resultPerson.toString());
                        result.setResultStatus(ResultStatus.PERSON);
                        result.setObject(resultPerson);
                        return result;
                        //如果用户不存在
                    }else{
                        result.setResultStatus(ResultStatus.NOTFOUND);
                        return result;
                    }
                    //扶贫单位
                }else{
                    //查询当前用户名或密码是否正确
                    ReliefCompany reliefCompany = new ReliefCompany();
                    reliefCompany.setUsername(username);
                    reliefCompany.setPassword(password);
                    //调用DAO进行查询
                    ReliefCompany resultCompany = reliefCompanyDao.searchByUAndP(reliefCompany);
                    //如果公司存在
                    if(resultCompany != null){
                        logger.info("after search: "+ reliefCompany.toString());
                        result.setResultStatus(ResultStatus.COMPANY);
                        result.setObject(resultCompany);
                        return result;
                        //公司不存在
                    }else{
                        result.setResultStatus(ResultStatus.NOTFOUND);
                        return result;
                    }
                }
            }else{
                //验证码错误
                result.setResultStatus(ResultStatus.FAILURE);
                return result;
            }
        }else{
            //参数缺失
            result.setResultStatus(ResultStatus.MISSING);
            return result;
        }
    }
    /**
     * 查询当前用户的扶贫项目
     *
     * @param id 用户ID
     * @return 扶贫项目
     */
    public Result searchProduction(Integer id) {
        Result result = new Result();
        Production production;
//        try {
            production = productionDao.searchByUserId(id);
//        }catch (Exception e){
//            logger.error("扶贫项目DAO searchProduction中出现错误");
//            result.setResultStatus(ResultStatus.FAILURE);
//            return result;
//        }
        result.setObject(production);
        result.setResultStatus(ResultStatus.SUCCESSFUL);
        return result;
    }


}
