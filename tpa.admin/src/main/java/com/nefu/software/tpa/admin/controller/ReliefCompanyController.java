package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.ReliefCompanyService;
import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;
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
 * Created by Super腾 on 2017/1/29.
 */
@Controller
public class ReliefCompanyController {

    private static Logger logger = LoggerFactory.getLogger(ReliefCompanyController.class);

    @Autowired
    public ReliefCompanyService reliefCompanyService;

    @RequestMapping("/toReliefCompany")
    public String toReliefPerson(HttpServletRequest request, @RequestParam Integer pageNumber){
        //调用业务层方法进行查询
        Result result = reliefCompanyService.selectAll();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            //正确查询
            List<ReliefCompany> list = (List<ReliefCompany>) result.getObject();
            for(ReliefCompany reliefCompany : list){
                //记录日志
                logger.info(reliefCompany.toString());
            }
            PageUtil pageUtil = new PageUtil(5,list.size(),pageNumber);
            pageUtil.setList(list);
            request.getSession().setAttribute("PageUtil",pageUtil);
            return "reliefCompany/reliefCompanyInformation";
        }
    }

    @RequestMapping("/toUpdateReliefCompany")
    public String toUpdateReliefCompany(ModelMap modelMap, @RequestParam Integer index, HttpServletRequest request){
        logger.info("需要修改的扶贫单位索引: "+index);
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
        List<ReliefCompany> list = pageUtil.getList();
        ReliefCompany reliefCompany = list.get(index);
        request.setAttribute("reliefCompany",reliefCompany);
        return "reliefCompany/updateReliefCompany";
    }

    @RequestMapping("/updateCompany")
    public String updateReliefCompany(@Valid ReliefCompany reliefCompany, BindingResult bindingResult, ModelMap modelMap){
        logger.info("需要修改的扶贫单位类："+reliefCompany.toString());
        //假如出现错误
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "reliefCompany/updateReliefCompany";
        }
        //正确进行操作
        Result result = reliefCompanyService.updateReliefCompany(reliefCompany);
        if(result.getResultStatus().code == 3){
            return "reliefCompany/updateReliefCompany";
        }else{
            return "adminHome";
        }
    }
}
