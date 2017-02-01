package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.Poverty;
import com.nefu.software.tpa.entity.entity.Village;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.ShowService;
import com.nefu.software.tpa.user.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 展示贫困个人和自然村的控制层
 *
 * Created by Super腾 on 2017/1/24.
 */
@Controller
public class ShowController {

    private static Logger logger = LoggerFactory.getLogger(ShowController.class);

    @Autowired
    public ShowService showService;

    /**
     * 分页查询全部贫困个人信息
     *
     * @param modelMap
     * @param pageNumber 当前页码
     * @return
     */
    @RequestMapping("/searchPoverty")
    public String showPoverty(ModelMap modelMap, @RequestParam String pageNumber){
        Result result = showService.showPoverty();
        //如果查询失败调至原页面
        if(result.getResultStatus().code == 3){
            return "reliefHome";
        }else{
            List<Poverty> list = (List<Poverty>) result.getObject();
            //记录查询日志
            for(Poverty poverty :list){
                logger.info(poverty.toString());
            }
            //包装成pageutil进行处理 每页5条记录，总共多少数据
            PageUtil pageUtil = new PageUtil(5,list.size(),Integer.parseInt(pageNumber));
            logger.info("fromIndex: "+pageUtil.getFromIndex()+" toIndex: "+pageUtil.getToIndex());
            pageUtil.setList(list);
            modelMap.addAttribute("PageUtil",pageUtil);
            return "search/povertyInformation";
        }
    }

    /**
     * 分页查询所有自然村信息
     *
     * @param modelMap 模型驱动
     * @param pageNumber 所有页码
     * @return 部分页面
     */
    @RequestMapping("/searchVillage")
    public String showVillage(ModelMap modelMap, @RequestParam String pageNumber){
        //调用业务层方法拿到结果
        Result result = showService.showVillage();
        if(result.getResultStatus().code == 3){
            //出现错误返回原来界面
            return "reliefHome";
        }else{
            //正确进行日志记录
            List<Village> list = (List<Village>) result.getObject();
            for(Village village : list){
                logger.info(village.toString());
            }
            //分页类包裹
            PageUtil pageUtil = new PageUtil(5,list.size(),Integer.parseInt(pageNumber));
            logger.info("fromIndex: "+pageUtil.getFromIndex()+" toIndex: "+pageUtil.getToIndex());
            //将信息存储起来进行返回
            pageUtil.setList(list);
            modelMap.addAttribute("PageUtil",pageUtil);
            return "search/villageInformation";
        }
    }
}
