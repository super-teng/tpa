package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.PRService;
import com.nefu.software.tpa.admin.service.PlanService;
import com.nefu.software.tpa.admin.service.ProductionService;
import com.nefu.software.tpa.entity.entity.PR;
import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;


/**
 *
 * 扶贫项目控制层
 *
 * Created by Super腾 on 2017/1/29.
 */
@Controller
public class ProductionController {

    private static Logger logger = LoggerFactory.getLogger(ProductionController.class);

    @Autowired
    public ProductionService productionService;

    @Autowired
    public PlanService planService;

    @Autowired
    public PRService prService;



    /**
     * 跳至扶贫项目页面
     * @param request 请求
     * @param pageNumber 页码
     * @return
     */
    @RequestMapping("/toProduction")
    public String toProduction(HttpServletRequest request, @RequestParam Integer pageNumber){
        //调用业务层方法进行查询
        Result result = productionService.selectAll();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            //正确查询
            List<Production> list = (List<Production>) result.getObject();
            for(Production production : list){
                //记录日志
                logger.info(production.toString());
            }
            request.getSession().setAttribute("production",list);
            PageUtil pageUtil = new PageUtil(5,list.size(),pageNumber);
            pageUtil.setList(list);
            request.getSession().setAttribute("PageUtil",pageUtil);
            return "production/productionInformation";
        }
    }

    /**
     * 扶贫项目通过
     * @param index 项目索引
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/passProduction")
    public String passProduction(@RequestParam Integer index, HttpServletRequest request, HttpServletResponse response){
        logger.info("验证通过的项目索引"+index);
        List<Production> list = (List<Production>) request.getSession().getAttribute("production");
        //通过的扶贫项目
        Production passProduction = list.get(index);
        //转化成扶贫计划进行插入
        Plan plan = new Plan();
        plan.setBeginTime(Date.valueOf(passProduction.getSubmitTime()));
        plan.setDetail(passProduction.getDetail());
        plan.setDuration(passProduction.getDuration());
        plan.setpName(passProduction.getpName());
        plan.setPovertyFlag(passProduction.getPovertyFlag());
        plan.setPovertyId(passProduction.getPid());
        plan.setReliefId(passProduction.getRid());
        plan.setReliefFlag(passProduction.getReliefFlag());
        Result result1 = planService.insertPlan(plan);
        logger.info(passProduction.toString());
        passProduction.setCheckDetail("通过");
        Result result2 = planService.searchPlanByIdAndFlag(plan);
        if(result2.getResultStatus().code == 3){
            return "production/productionInformation";
        }else{
            Plan plan1 = (Plan) result2.getObject();
            PR pr = new PR();
            pr.setrFlag(plan.getReliefFlag());
            pr.setpFlag(plan.getPovertyFlag());
            pr.setPid(plan.getPovertyId());
            pr.setRid(plan.getReliefId());
            pr.setPlanId(plan1.getPlanId());
            Result result3 = prService.insertPR(pr);
            if(result3.getResultStatus().code == 3){
                return "production/productionInformation";
            }
        }
        Result result = productionService.passProduction(passProduction);
        if(result.getResultStatus().code == 3 || result1.getResultStatus().code == 3){
            return "production/productionInformation";
        }else{
            //重定向到扶贫项目首页
            return "redirect:/toProduction?pageNumber=1";
        }
    }

    /**
     * 跳至未通过扶贫项目页面
     * @param modelMap
     * @param index
     * @return
     */
    @RequestMapping("/toNoPassProduction")
    public String toNoPassProduction(ModelMap modelMap,@RequestParam String index){
        modelMap.addAttribute("index",index);
        return "production/noPass";
    }

    /**
     * 扶贫项目未通过
     * @param index
     * @param reason
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/noPass")
    public String noPassProduction(@RequestParam Integer index,@RequestParam String reason, HttpServletRequest request, HttpServletResponse response){
        logger.info("验证未通过的项目索引"+index);
        List<Production> list = (List<Production>) request.getSession().getAttribute("production");
        //未通过的扶贫项目
        Production passProduction = list.get(index);
        logger.info(passProduction.toString());
        passProduction.setCheckDetail("未通过："+reason);
        Result result = productionService.passProduction(passProduction);
        if(result.getResultStatus().code == 3){
            return "production/productionInformation";
        }else{
            //重定向到扶贫项目首页
            return "redirect:/toProduction?pageNumber=1";
        }
    }
}
