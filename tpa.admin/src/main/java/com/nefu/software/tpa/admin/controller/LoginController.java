package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.LoginService;
import com.nefu.software.tpa.entity.constant.Constants;
import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.response.Result;
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
 * 登录控制层
 *
 * Created by Super腾 on 2017/1/22.
 */
@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    //验证码类
    @Autowired
    public RandomValidateCode randomValidateCode;

    @Autowired
    public LoginService loginService;

    /**
     * 登录
     *
     * @param request 浏览器传来请求
     * @param vcode 管理员填写的验证码
     * @param username 用户名
     * @param password 密码
     * @return 跳转路径
     */
    @RequestMapping("/adminLogin")
    public String login(HttpServletRequest request,@RequestParam String vcode,@RequestParam String username, @RequestParam String password){
        //获取真实的验证码从session中进行获取
        String sessionCode = request.getSession().getAttribute(Constants.RANDOM_CODE_KEY).toString();
        //如果用户填写验证码错误
        if(!sessionCode.equals(vcode)){
            request.setAttribute("vcodeMessage","验证码错误");
            return "index";
        }else{
            //验证码填写正确进行其他验证
            Result result = loginService.login(username,password);
            if(result.getResultStatus().code == 5){
                request.setAttribute("message","参数丢失");
                return "index";
            }else if(result.getResultStatus().code == 4){
                request.setAttribute("message","用户名或密码错误");
                return "index";
            }else{
                Admin admin = (Admin)result.getObject();
                request.getSession().setAttribute("admin",admin);
                return "adminHome";
            }
        }
    }

    @RequestMapping("/toAdmin")
    public String toAdminHome(){
        return "adminHome";
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
}
