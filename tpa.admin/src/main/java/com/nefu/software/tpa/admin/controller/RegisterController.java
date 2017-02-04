package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.RegisterService;
import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.entity.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 管理员注册控制层
 *
 * Created by Super腾 on 2017/1/27.
 */
@Controller
public class RegisterController {

    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    public RegisterService registerService;

    /**
     * 跳到注册页面
     *
     * @return  页面地址
     */
    @RequestMapping("/toRegisterAdmin")
    public String toAdminRegister(){
        return "register/registerAdmin";
    }
    @RequestMapping("/registerAdmin")
    public String adminRegister(@Valid Admin admin, BindingResult bindingResult, HttpServletRequest request, ModelMap modelMap){
        //如果出现错误进行返回
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError:list){
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
            }
            //返回注册页面
            return "register/registerAdmin";
        }
        Result result = registerService.registerAdmin(admin);
        if(result.getResultStatus().code == 3){
            return "register/registerAdmin";
        }else{
            logger.info(admin.toString());
            return "index";
        }
    }

    @RequestMapping("/toAdminHome")
    public String toAdminHome(){
        return "adminHome";
    }
}
