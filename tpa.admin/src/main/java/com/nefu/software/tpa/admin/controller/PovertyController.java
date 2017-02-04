package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.PovertyService;
import com.nefu.software.tpa.entity.entity.Poverty;
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
 * 贫困用户的控制层
 *
 * Created by Super腾 on 2017/1/28.
 */
@Controller
public class PovertyController {

    private static Logger logger = LoggerFactory.getLogger(PovertyController.class);

    @Autowired
    public PovertyService povertyService;

    /**
     * 调至贫困用户页面
     * @param request 请求
     * @param pageNumber 页面编号
     * @return 部分页面路径
     */
    @RequestMapping("/toPoverty")
    public String toPovertyInformation(HttpServletRequest request, @RequestParam String pageNumber){
        Result result = povertyService.searchAllPoverty();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            List<Poverty> list = (List<Poverty>) result.getObject();
            for(Poverty poverty : list){
                //日志记录
                logger.info(poverty.toString());
            }
            //包装成pageUtil类
            PageUtil pageUtil = new PageUtil(5,list.size(),Integer.parseInt(pageNumber));
            logger.info("fromIndex: "+pageUtil.getFromIndex()+" toIndex: "+pageUtil.getToIndex());
            pageUtil.setList(list);
            request.getSession().setAttribute("PageUtil",pageUtil);
            return "/poverty/povertyInformation";
        }
    }

    /**
     * 跳转至更新单个贫困用户页面
     * @param modelMap 模型驱动
     * @param request 请求
     * @param index  贫困用户编号
     * @return 部分页面路径
     */
    @RequestMapping("/toUpdatePoverty")
    public String toUpdatePoverty(ModelMap modelMap,HttpServletRequest request,@RequestParam Integer index){
        logger.info("需要修改的贫困个人类索引："+index);
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
        List<Poverty> list = pageUtil.getList();
        //获取到当前需要修改的实体类
        Poverty poverty = list.get(index);
        modelMap.addAttribute("poverty",poverty);
        return "poverty/updatePoverty";
    }

    @RequestMapping("/updatePoverty")
    public String updatePoverty(@Valid Poverty poverty, BindingResult bindingResult,ModelMap modelMap){
        logger.info("待更新的贫困个人信息："+poverty);
        //假如出现错误
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+ fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "poverty/updatePoverty";
        }
        Result result = povertyService.updatePoverty(poverty);
        if(result.getResultStatus().code == 3){
            return "poverty/updatePoverty";
        }else{
            return "adminHome";
        }
    }

    @RequestMapping("/toInsertPoverty")
    public String toInsertPoverty(){
        return "poverty/insertPoverty";
    }

    @RequestMapping("/insertPoverty")
    public String insertPoverty(@Valid Poverty poverty,BindingResult bindingResult,ModelMap modelMap){
        logger.info("待插入的贫困个人信息："+poverty.toString());
        //假如出现错误
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+ fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "poverty/insertPoverty";
        }
        Result result = povertyService.insertPoverty(poverty);
        if(result.getResultStatus().code == 3){
            return "poverty/insertPoverty";
        }else{
            return "redirect:toPoverty?pageNumber=1";
        }
    }
}
