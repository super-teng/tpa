package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.PRService;
import com.nefu.software.tpa.admin.service.PlanLogService;
import com.nefu.software.tpa.admin.service.PlanService;
import com.nefu.software.tpa.admin.service.ProductionService;
import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.PlanLog;
import com.nefu.software.tpa.entity.entity.Village;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 扶贫计划
 *
 * Created by Super腾 on 2017/2/3.
 */
@Controller
public class PlanController {

    private static Logger logger = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    public PlanService planService;

    @Autowired
    public ProductionService productionService;

    @Autowired
    public PlanLogService planLogService;

    @Autowired
    public PRService prService;

    /**
     * 跳至扶贫计划页面
     * @param pageNumber
     * @param request
     * @return
     */
    @RequestMapping("/toPlan")
    public String toPlan(@RequestParam Integer pageNumber, HttpServletRequest request){
        Result result = planService.searchAllPlan();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            List<Plan> list = (List<Plan>) result.getObject();
            for(Plan plan : list){
                logger.info(plan.toString());
            }
            PageUtil pageUtil = new PageUtil(5,list.size(),pageNumber);
            pageUtil.setList(list);
            request.getSession().setAttribute("adminPageUtil",pageUtil);
            return "plan/planInformation";
        }
    }

    /**
     * 删除扶贫计划
     * @param request
     * @param index
     * @return
     */
    @RequestMapping("/deletePlan")
    public String deletePlan(HttpServletRequest request,@RequestParam Integer index){
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("adminPageUtil");
        List<Plan> list = pageUtil.getList();
        Plan plan = list.get(index);
        List<PlanLog> logList = plan.getList();
        for(PlanLog planLog :logList){
            planLogService.deletePlanLog(planLog.getLid());
        }
        prService.deletePR(plan.getPlanId());
        logger.info("要删除的扶贫计划："+plan.toString());
        int id = plan.getPlanId();
        planService.deletePlanById(id);
        productionService.deleteProduction(plan.getReliefId());
        return "redirect:toPlan?pageNumber=1";
    }
}
