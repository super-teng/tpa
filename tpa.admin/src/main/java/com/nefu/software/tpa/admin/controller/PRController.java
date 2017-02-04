package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.admin.service.PRService;
import com.nefu.software.tpa.admin.service.PlanService;
import com.nefu.software.tpa.entity.entity.PR;
import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 帮扶结对类
 *
 * Created by Super腾 on 2017/2/3.
 */
@Controller
public class PRController {

    private static Logger logger = LoggerFactory.getLogger(PRController.class);

    @Autowired
    public PRService prService;

    @Autowired
    public PlanService planService;

    @RequestMapping("/toPR")
    public String toPR(@RequestParam Integer pageNumber, HttpServletRequest request){
        Result result = new Result();
        result = prService.selectAll();
        if(result.getResultStatus().code == 3){
            return "adminHome";
        }else{
            List<PR> list = (List<PR>) result.getObject();
            for(PR pr : list){
                logger.info(pr.toString());
            }
            PageUtil pageUtil = new PageUtil(5,list.size(),pageNumber);
            pageUtil.setList(list);
            request.setAttribute("prPageUtil",pageUtil);
            return "pr/prInformation";
        }
    }

    /**
     * 通过扶贫计划ID来查询扶贫计划
     * @param planId
     * @return
     */
    @RequestMapping("/searchPlan")
    public String searchPlan(@RequestParam Integer planId,HttpServletRequest request){
        Result result = planService.searchById(planId);
        if(result.getResultStatus().code == 3){
            return "redirect:toPR?pageNumber=1";
        }else{
            Plan plan = (Plan) result.getObject();
            logger.info("查看的扶贫计划："+plan.toString());
            request.setAttribute("searchPlan",plan);
            return "pr/planInformation";
        }
    }

    /**
     * 跳至扶贫结对页面
     * @return
     */
    @RequestMapping("/toPRInformation")
    public String toPRInformation(){
        return "redirect:toPR?pageNumber=1";
    }
}
