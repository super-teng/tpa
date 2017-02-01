package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.ReliefPersonService;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import com.nefu.software.tpa.entity.entity.Village;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;
import com.sun.javafx.sg.prism.NGShape;
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
import java.util.Map;

/**
 * 扶贫个人控制层
 *
 * Created by Super腾 on 2017/1/29.
 */
@Controller
public class ReliefPersonController {

    private static Logger logger = LoggerFactory.getLogger(ReliefPersonController.class);

    @Autowired
    public ReliefPersonService reliefPersonService;

    @RequestMapping("/toReliefPerson")
    public String toReliefPerson(HttpServletRequest request, @RequestParam Integer pageNumber){
        //调用业务层方法进行查询
        Result result = reliefPersonService.selectAll();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            //正确查询
            List<ReliefPerson> list = (List<ReliefPerson>) result.getObject();
            for(ReliefPerson reliefPerson : list){
                //记录日志
                logger.info(reliefPerson.toString());
            }
            PageUtil pageUtil = new PageUtil(5,list.size(),pageNumber);
            pageUtil.setList(list);
            request.getSession().setAttribute("PageUtil",pageUtil);
            return "reliefPerson/reliefPersonInformation";
        }
    }
    @RequestMapping("/toUpdateReliefPerson")
    public String toUpdateReliefPerson( ModelMap modelMap,@RequestParam Integer index,HttpServletRequest request){
        logger.info("需要修改的扶贫个人索引: "+index);
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
        List<ReliefPerson> list = pageUtil.getList();
        ReliefPerson reliefPerson = list.get(index);
        request.setAttribute("reliefPerson",reliefPerson);
        return "reliefPerson/updateReliefPerson";
    }

    @RequestMapping("/updateReliefPerson")
    public String updateReliefPerson(@Valid ReliefPerson reliefPerson, BindingResult bindingResult, ModelMap modelMap){
        logger.info("需要修改的扶贫个人类："+reliefPerson.toString());
        //假如出现错误
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "reliefPerson/updateReliefPerson";
        }
        //正确进行操作
        Result result = reliefPersonService.updateReliefPerson(reliefPerson);
        if(result.getResultStatus().code == 3){
            return "reliefPerson/updateReliefPerson";
        }else{
            return "adminHome";
        }
    }
}
