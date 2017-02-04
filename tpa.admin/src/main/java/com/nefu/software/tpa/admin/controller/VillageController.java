package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.VillageService;
import com.nefu.software.tpa.entity.entity.Village;
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
 * 自然村控制层
 *
 * Created by Super腾 on 2017/1/29.
 */
@Controller
public class VillageController {

    private static Logger logger = LoggerFactory.getLogger(VillageController.class);

    @Autowired
    public VillageService villageService;


    /**
     * 跳到自然村页面
     * @param request 请求
     * @param pageNumber 页面编号
     * @return
     */
    @RequestMapping("/toVillage")
    public String toVillage(HttpServletRequest request, @RequestParam Integer pageNumber){
        //调用业务层方法进行查询
        Result result = villageService.selectAll();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            //正确查询
            List<Village> list = (List<Village>) result.getObject();
            for(Village village : list){
                //记录日志
                logger.info(village.toString());
            }
            PageUtil pageUtil = new PageUtil(5,list.size(),pageNumber);
            pageUtil.setList(list);
            request.getSession().setAttribute("PageUtil",pageUtil);
            return "village/villageInformation";
        }
    }

    /**
     *  跳至更新
     * @param request
     * @param index
     * @return
     */

    @RequestMapping("/toUpdateVillage")
    public String toUpdateVillage(HttpServletRequest request,@RequestParam Integer index){
        logger.info("需要修改的自然村索引: "+index);
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("PageUtil");
        List<Village> list = pageUtil.getList();
        Village village = list.get(index);
        request.setAttribute("village",village);
        return "village/updateVillage";
    }

    @RequestMapping("/updateVillage")
    public String updateVillage(@Valid Village village, BindingResult bindingResult, ModelMap modelMap){
        logger.info("需要修改的自然村类："+village.toString());
        //假如出现错误
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "village/updateVillage";
        }
        //正确进行操作
        Result result = villageService.updateVillage(village);
        if(result.getResultStatus().code == 3){
            return "village/updateVillage";
        }else{
            return "adminHome";
        }
    }

    @RequestMapping("/toInsertVillage")
    public String toInsertVillage(){
        return "village/insertVillage";
    }

    @RequestMapping("insertVillage")
    public String insertVillage(@Valid Village village,BindingResult bindingResult,ModelMap modelMap){
        logger.info("需要新增的自然村类："+village.toString());
        //假如出现错误
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "village/insertVillage";
        }
        //正确进行操作
        Result result = villageService.insertVillage(village);
        if(result.getResultStatus().code == 3){
            return "village/insertVillage";
        }else{
            return "redirect:toVillage?pageNumber=1";
        }
    }

}
