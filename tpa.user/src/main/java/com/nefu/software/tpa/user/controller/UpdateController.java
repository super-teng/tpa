package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.UpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 更新扶贫主体信息
 *
 * Created by Super腾 on 2017/1/24.
 */
@Controller
public class UpdateController {

    private  static Logger logger = LoggerFactory.getLogger(UpdateController.class);

    @Autowired
    public UpdateService updateService;

    /**
     *根据身份不同跳转到不同的更新页面
     *
     * @param request  请求用于获取session
     * @return 跳转的路径
     */
    @RequestMapping("toUpdate")
    public String toUpdate(HttpServletRequest request){
        //取出当前session中的身份信息
        Integer identity = (Integer)request.getSession().getAttribute("identity");
        logger.info("identity: " + identity.intValue());
        //身份1跳到扶贫个人界面，身份2跳到扶贫单位界面
        if(identity == 1){
            return "informationManager/updatePerson";
        }else{
            return "informationManager/updateCompany";
        }
    }

    /**
     * 个人信息更新
     *
     * @param reliefPerson 包装类
     * @param bindingResult  错误信息
     * @param modelMap 模型驱动
     * @param verifyPassword 确认密码
     * @param request 请求
     * @return 页面url
     */
    @RequestMapping("updatePerson")
    public String updatePerson(@Valid ReliefPerson reliefPerson, BindingResult bindingResult, ModelMap modelMap, @RequestParam String verifyPassword ,HttpServletRequest request){
        //判断是否有错误信息
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError:list){
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
            }
            return "informationManager/updatePerson";
        }
        logger.info("verifyPassword : "+verifyPassword+" password : "+reliefPerson.getPassword());
        //判断两次密码是否一致
        if(!verifyPassword.equals(reliefPerson.getPassword())){
            modelMap.addAttribute("ERR_verifyPassword","两次输入密码不一致");
            return "informationManager/updatePerson";
        }
        //进行更新
        Result result = updateService.reliefPersonUpdate(reliefPerson);
        //更新成功跳转至成功页面否则则返回当前更新页面
        if(result.getResultStatus().code == 2){
            //将更新后的用户信息存储进session中
            request.getSession().setAttribute("reliefPerson",reliefPerson);
            return "reliefHome";
        }else{
            return "informationManager/updatePerson";
        }
    }

    /**
     * 更新单位信息
     *
     * @param reliefCompany 单位包装类
     * @param bindingResult 错误信息
     * @param request 发来请求
     * @param modelMap 模型驱动
     * @param verifyPassword 确认密码
     * @return 页面路径
     */
    @RequestMapping("/updateCompany")
    public String updateCompany(@Valid ReliefCompany reliefCompany,BindingResult bindingResult,HttpServletRequest request, ModelMap modelMap,@RequestParam String verifyPassword){
        logger.info(reliefCompany.toString());
        if(bindingResult.hasErrors()){
            //验证中出现错误返回更新页面并把错误信息返回回去
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError fieldError : errors){
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "informationManager/updateCompany";
        }
        //如果两次密码不相同
        if(verifyPassword != reliefCompany.getPassword()){
            modelMap.addAttribute("ERR_verifyPassword","两次密码不一致");
        }
        //调用service方法进行更新
        Result result = updateService.reliefCompanyUpdate(reliefCompany);
        //判断更新是否成功
        if(result.getResultStatus().code == 3){
            //更新失败跳回本页面
            return "informationManager/updateCompany";
        }else{
            //更新成功
            request.getSession().setAttribute("reliefCompany",reliefCompany);
            return "reliefHome";
        }
    }



}
