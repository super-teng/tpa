package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.entity.entity.Admin;
import com.nefu.software.tpa.admin.service.UpdateService;
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
 * 更新管理员信息控制层
 *
 * Created by Super腾 on 2017/1/27.
 */
@Controller
public class UpdateController {


    private static Logger logger = LoggerFactory.getLogger(UpdateController.class);

    @Autowired
    public UpdateService updateService;
    /**
     * 跳转至管理员更新页面
     * @param modelMap
     * @return
     */
    @RequestMapping("/toUpdateAdmin")
    public String toUpdate(ModelMap modelMap){
        return "/admin/updateAdmin";
    }

    @RequestMapping("/updateAdmin")
    public String updateAdmin(@Valid Admin admin, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request){
        //如果出现错误进行返回
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError:list){
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
            }
            //返回注册页面
            return "admin/updateAdmin";
        }
        Result result = updateService.updateAdmin(admin);
        if(result.getResultStatus().code == 3){
            return "admin/updateAdmin";
        }else{
            request.getSession().setAttribute("admin",admin);
            return "adminHome";
        }
    }
}
