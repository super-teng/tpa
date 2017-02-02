package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.ProductionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 扶贫项目的控制层
 *
 * Created by Super腾 on 2017/1/25.
 */
@Controller
public class ProductionController {

    private static Logger logger = LoggerFactory.getLogger(ProductionController.class);

    @Autowired
    public ProductionService productionService;

    /**
     * 前往扶贫项目页面
     *
     * @return
     */
    @RequestMapping("/povertyProduction")
    public String toProject(){
        return "production/applyForProduction";
    }

    /**
     * 申请扶贫项目
     *
     * @param modelMap 模型类
     * @param production 扶贫项目类
     * @param bindingResult 出错信息集合
     * @param request 请求
     * @param flag 贫困主体标记
     * @param id 贫困肢体ID号
     * @return 部分结果页面
     */
    @RequestMapping(value = "/applyFor",method = RequestMethod.POST)
    public String applyForProduction(ModelMap modelMap, @Valid Production production, BindingResult bindingResult, HttpServletRequest request,@RequestParam String flag, @RequestParam String id){
        logger.info("flag: " + flag+" id: "+id);

        //存在校验错误进行返回
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField()+" : "+fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "production/applyForProduction";
        }
        //记录当前要扶贫对象的身份
        if(flag.equals("povertyFlag")){
            //扶贫个人
            production.setPovertyFlag("0");
        }else{
            //自然村
            production.setPovertyFlag("1");
        }
        //记录扶贫对象身份
        logger.info("identity : "+String.valueOf(Integer.parseInt(request.getSession().getAttribute("identity").toString()) -1));
        production.setReliefFlag(String.valueOf(Integer.parseInt(request.getSession().getAttribute("identity").toString()) -1));
        //存储贫困用户ID
        production.setPid(Integer.parseInt(id));
        //存储扶贫人员ID
        production.setRid(Integer.parseInt(request.getSession().getAttribute("id").toString()));
        production.setCheckDetail("未审核");
        //插入当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        production.setSubmitTime(df.format(new Date()));
        logger.info(production.toString());
        Result result = productionService.applyForProduction(production);
        if(result.getResultStatus().code == 3){
            return "production/applyForProduction";
        }else{
            //将扶贫项目进展和实体类存入session中进行管理
            request.getSession().setAttribute("productionStatus","未审核");
            request.getSession().setAttribute("production",production);
            return "reliefHome";
        }
    }

    /**
     * 查看当前项目进展
     * @return
     */
    @RequestMapping("/productionProgress")
    public String productionProgress(HttpServletRequest request){
        Integer id = (Integer) request.getSession().getAttribute("id");
        logger.info("当前用户ID："+id);
        Production production = productionService.searchByRid(id);
        if(production == null){
            request.getSession().setAttribute("productionStatus","未提交扶贫项目");
        }else if(production != null && production.getCheckDetail() == null){
            request.getSession().setAttribute("productionStatus","未审核");
        }else{
            request.getSession().setAttribute("productionStatus",production.getCheckDetail());
        }
        return "production/productionStatus";
    }

    /**
     * 前往扶贫项目更新页面
     *
     * @return
     */
    @RequestMapping("/toUpdateProduction")
    public String toUpdateProduction(HttpServletRequest request){
        Integer userId = (Integer) request.getSession().getAttribute("id");
        Integer temp = (Integer) request.getSession().getAttribute("identity");
        String flag = String.valueOf(temp-1);
        Result result = productionService.searchByUserIdAndFlag(userId,flag);
        if (result.getResultStatus().code == 3) {
            return "reliefHome";
        }else{
            Production production = (Production) result.getObject();
            logger.info("待更新的扶贫项目："+production.toString());
            request.setAttribute("updateProduction",production);
            return "production/updateProduction";
        }
    }

    @RequestMapping("/updateProduction")
    public String  updateProduction(@Valid Production production,BindingResult bindingResult,ModelMap modelMap,HttpServletRequest request,@RequestParam String flag,@RequestParam String id){
        logger.info(production.toString());
        if(bindingResult.hasErrors()){
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError fieldError : list){
                logger.info(fieldError.getField(),fieldError.getDefaultMessage());
                modelMap.addAttribute("ERR_"+fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "production/updateProduction";
        }
        Production updateProduction = (Production) request.getAttribute("updateProduction");
        //记录当前要扶贫对象的身份
        if(flag.equals("povertyFlag")){
            //扶贫个人
            production.setPovertyFlag("0");
        }else{
            //自然村
            production.setPovertyFlag("1");
        }
        //记录扶贫对象身份
        logger.info("identity : "+String.valueOf(Integer.parseInt(request.getSession().getAttribute("identity").toString()) -1));
        production.setReliefFlag(String.valueOf(Integer.parseInt(request.getSession().getAttribute("identity").toString()) -1));
        //存储贫困用户ID
        production.setPid(Integer.parseInt(id)) ;
        //存储扶贫人员ID
        production.setRid(Integer.parseInt(request.getSession().getAttribute("id").toString()));
        production.setCheckDetail("未审核");
        production.setProId(production.getProId());
        logger.info(production.toString());
        //插入当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        production.setSubmitTime(df.format(new Date()));
        //至此包装完毕
        Result result = productionService.updateProduction(production);
        if(result.getResultStatus().code == 3){
            return "production/updateProduction";
        }else{
            //将扶贫项目进展和实体类存入session中进行管理
            request.getSession().setAttribute("productionStatus","未审核");
            request.getSession().setAttribute("production",production);
            return "reliefHome";
        }
    }
}
