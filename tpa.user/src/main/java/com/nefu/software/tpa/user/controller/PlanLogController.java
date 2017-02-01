package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.PlanLog;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.PlanLogService;
import com.nefu.software.tpa.user.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 扶贫日志
 *
 * Created by Super腾 on 2017/2/1.
 */
@Controller
public class PlanLogController {

    private static Logger logger = LoggerFactory.getLogger(PlanLogController.class);

    @Autowired
    public PlanLogService planLogService;

    @Autowired
    public PlanService planService;

    /**
     * 跳至上传扶贫日志页面
     * @return
     */
    @RequestMapping("/toUploadPlanLog")
    public String toUploadPlanLog(){
        return "planLog/uploadPlanLog";
    }

    /**
     * 上传扶贫日志
     * @return
     */
    @RequestMapping("/uploadPlanLog")
    public String uploadPlanLog(@RequestParam MultipartFile file, HttpServletRequest request){
        //路径
        String uploadUrl = request.getSession().getServletContext().getRealPath("/")+"upload/";
        //文件名
        String fileName = file.getOriginalFilename();
        //判断当前路径是否存在如不存在进行创建
        File dir = new File(uploadUrl);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //如果当前文件不存在进行创建一个
        File targetFile = new File(uploadUrl + fileName);
        if(!targetFile.exists()){
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("上传路径为："+uploadUrl +" "+ fileName);
        //将文件上传到指定位置中去
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将信息插入到数据库中
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        PlanLog planLog = new PlanLog();
        logger.info("时间："+java.sql.Date.valueOf(df.format(new Date())));
        planLog.setSubmitTime(java.sql.Date.valueOf(df.format(new Date())));
        Integer reliefId = (Integer) request.getSession().getAttribute("id");
        Result result = planService.searchByUserIdAndFlag(reliefId);
        Plan plan = (Plan) result.getObject();
        if(plan == null){
            return "reliefHome";
        }else{
            planLog.setPlan(plan);
            planLog.setLogUrl(uploadUrl+fileName);
            //调用业务层方法
            Result result1 = planLogService.insertPlanLog(planLog);
            if(result1.getResultStatus().code == 3){
                return "/planLog/uploadPlanLog";
            }else{
                return "reliefHome";
            }
        }
    }
}
