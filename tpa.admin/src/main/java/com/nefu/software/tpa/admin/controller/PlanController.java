package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.PlanService;
import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;
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

}
