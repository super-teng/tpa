package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.Production;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.PlanService;
import com.nefu.software.tpa.user.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 扶贫计划控制层
 *
 * Created by Super腾 on 2017/1/31.
 */
@Controller
public class PlanController {

    private static Logger logger = LoggerFactory.getLogger(PlanController.class);

    @Autowired
    public PlanService planService;

    //跳转至扶贫计划页面
    @RequestMapping("/searchPlan")
    public String toPlan(HttpServletRequest request){
        //用户ID
        Integer userId  = (Integer) request.getSession().getAttribute("id");
        logger.info(String.valueOf(userId));
        Result result = planService.searchById(userId);
        if(result.getResultStatus().code == 3){
            return "reliefHome";
        }else{
            Plan plan = (Plan) result.getObject();
            logger.info(plan.toString());
            request.getSession().setAttribute("plan",plan);
            return "plan/planInformation";
        }
    }
}
