package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * 注册控制层
 *
 * Created by Super腾 on 2017/1/22.
 */
@Controller
public class RegisterController{

    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    public RegisterService registerService;
    /**
     * 跳转至扶贫个人注册页面
     *
     * @return 页面地址
     */
    @RequestMapping("reliefPersonRegister")
    public String toPersonRegister(){
        return "register/reliefPersonRegister";
    }

    /**
     * 跳转至扶贫单位注册页面
     *
     * @return 页面地址
     */
    @RequestMapping("reliefCompanyRegister")
    public String toCompanyRegister(){
        return "register/reliefCompanyRegister";
    }

    /**
     * 扶贫个人注册
     *
     * @param reliefPerson 需要验证的实体类
     * @param bindingResult 需要绑定的结果信息
     * @param modelMap 模型驱动类
     * @return 返回页面
     */
    @RequestMapping("personRegister")
    public String PersonRegister(@Valid ReliefPerson reliefPerson, BindingResult bindingResult , ModelMap modelMap,@RequestParam String verifyPassword){
        //如果绑定的结果信息中存在错误信息的话
        if(bindingResult.hasErrors()){
            //把产生的错误域信息给存储起来
            List<FieldError> errors = bindingResult.getFieldErrors();
            //将所用的错误信息存入模型驱动中返回回去
            for(FieldError fieldError:errors){
                //将那个域产生的错误信息给记录下来
                logger.info(fieldError.getField()+": "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "register/reliefPersonRegister";
        }
        logger.info("verifyPassword: "+verifyPassword+" password: "+reliefPerson.getPassword());
        //如果两次输入密码不一致的话
        if(!verifyPassword.equals(reliefPerson.getPassword())){
            modelMap.addAttribute("ERR_verifyPassword","两次输入密码不一致");
            return "register/reliefPersonRegister";
        }else{
            //正确的话进行插入处理
            logger.info(reliefPerson.toString());
            //执行插入操作
            Result result = registerService.reliefPersonRegister(reliefPerson);
            //检验数据在插入数据库期间是否出现错误
            if(result.getResultStatus().code == 3){
                return "register/reliefPersonRegister";
            }else{
                return "index";
            }
        }
    }

    /**
     * 扶贫单位注册
     *
     * @param reliefCompany 单位实体类
     * @param bindingResult 绑定结果信息
     * @param modelMap 数据模型
     * @return  返回页面参数
     */
    @RequestMapping("companyRegister")
    public String companyRegister(@Valid ReliefCompany reliefCompany,BindingResult bindingResult,ModelMap modelMap,@RequestParam String verifyPassword){
        //如果存在错误信息
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                logger.info(fieldError.getField()+": "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "register/reliefCompanyRegister";
        }
        //插入信息
        logger.info(reliefCompany.toString());
        logger.info("verifyPassword: "+verifyPassword+" password: "+reliefCompany.getPassword());
        //判断两次密码是否相等
        if(!verifyPassword.equals(reliefCompany.getPassword())){
            modelMap.addAttribute("ERR_verifyPassword","两次输入密码不一致");
            return "register/reliefCompanyRegister";
        }else{
            Result result = registerService.reliefCompanyRegister(reliefCompany);
            if(result.getResultStatus().code == 3){
                return "register/reliefCompanyRegister";
            }else{
                return "index";
            }
        }

    }
}
