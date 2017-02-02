package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.constant.Constants;
import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.enums.ResultStatus;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.LoginInService;
import com.nefu.software.tpa.user.util.RandomValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 扶贫用户登录类
 *
 * Created by Super腾 on 2017/1/18.
 */
@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    //验证码类
    @Autowired
    public RandomValidateCode randomValidateCode;

    //登录业务逻辑层
    @Autowired
    public LoginInService loginInService;

    /**
     * 登录的控制层
     *
     * @param request  请求request
     * @param vcode  用户填写的验证码
     * @param username  用户名
     * @param password 密码
     * @param identity 用户身份
     * @return  结果页面
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, @RequestParam String vcode, @RequestParam String username, @RequestParam String password,@RequestParam String identity) {
        //获取真实的验证码从session中进行获取
        String sessionCode = request.getSession().getAttribute(Constants.RANDOM_CODE_KEY).toString();
        logger.info("username: "+username+" password: "+password+" identity: "+identity+" uservcode: "+vcode+" realvcode "+ sessionCode);
        //调用业务层方法
        Result result = loginInService.login(username,password,vcode,sessionCode,identity);
        ResultStatus rs = result.getResultStatus();
        //扶贫个人登录成功
        if(rs.code == 0){
            //存储扶贫个人到session中
            ReliefPerson reliefPerson = (ReliefPerson) result.getObject();
            request.getSession().setAttribute("reliefPerson",reliefPerson);
            request.getSession().setAttribute("id",reliefPerson.getRid());
            //扶贫个人的登录标记为1
            request.getSession().setAttribute("identity",1);
            //记录扶贫项目状态
            Result result1 = loginInService.searchProduction(reliefPerson.getRid());
            Production production = (Production)result1.getObject();
            if(production  == null){
                logger.info("空的！！！！！！");
                request.getSession().setAttribute("productionStatus","未提交扶贫项目");
            }else{
                request.getSession().setAttribute("productionStatus",production.getCheckDetail());
                request.getSession().setAttribute("production",production);
            }
            return "reliefHome";
            //扶贫单位登录成功
        }else if(rs.code == 1) {
            //存储扶贫单位到session中
            ReliefCompany reliefCompany = (ReliefCompany) result.getObject();
            request.getSession().setAttribute("reliefCompany",reliefCompany);
            request.getSession().setAttribute("id",reliefCompany.getCid());
            //扶贫单位的登录标记为2
            request.getSession().setAttribute("identity",2);
            Result result1 = loginInService.searchProduction(reliefCompany.getCid());
            Production production = (Production) result1.getObject();
            if(result1.getObject() == null){
                request.getSession().setAttribute("productionStatus","未提交扶贫项目");
            }else{
                request.getSession().setAttribute("productionStatus",production.getCheckDetail());
                request.getSession().setAttribute("production",production);
            }
            return "reliefHome";
            //验证码错误
        } else if(rs.code == 3){
            request.setAttribute("vcodeMessage","验证码错误");
            return "index";
            //用户名或密码错误
        }else if(rs.code == 4){
            request.setAttribute("message","用户名或密码错误");
            return  "index";
        }else{
            request.setAttribute("message","参数缺失");
            return "index";
        }
    }

    /**
     * 生成验证码的方法
     *
     * @param request  请求
     * @param response 相应
     */
    @RequestMapping("/vcode")
    public void verify(HttpServletRequest request, HttpServletResponse response) {
        randomValidateCode.getRandcode(request, response);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/returnHome")
    public String returnHome(){
        return "reliefHome";
    }

}
