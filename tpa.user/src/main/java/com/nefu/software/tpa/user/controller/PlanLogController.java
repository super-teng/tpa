package com.nefu.software.tpa.user.controller;

import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.PlanLog;
import com.nefu.software.tpa.entity.response.Result;
import com.nefu.software.tpa.user.service.PlanLogService;
import com.nefu.software.tpa.user.service.PlanService;
import com.nefu.software.tpa.user.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public String toUploadPlanLog(HttpServletRequest request){
        //用户ID
        Integer userId  = (Integer) request.getSession().getAttribute("id");
        logger.info(String.valueOf(userId));
        Result result = planService.searchById(userId);
        if(result.getResultStatus().code == 3){
            return "reliefHome";
        }else{
            return "planLog/uploadPlanLog";
        }
    }

    /**
     * 上传扶贫日志
     * @return
     */
    @RequestMapping("/uploadPlanLog")
    public String uploadPlanLog(@RequestParam MultipartFile file,@RequestParam String detail, HttpServletRequest request){
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
        Result result = planService.searchById(reliefId);
        Plan plan = (Plan) result.getObject();
        if(plan == null){
            return "reliefHome";
        }else{
            planLog.setPlan(plan);
            planLog.setLogUrl(uploadUrl+fileName);
            planLog.setDetail(detail);
            //调用业务层方法
            Result result1 = planLogService.insertPlanLog(planLog);
            if(result1.getResultStatus().code == 3){
                return "/planLog/uploadPlanLog";
            }else{
                return "reliefHome";
            }
        }
    }

    /**
     * 查询当前扶贫计划的扶贫日志
     * @return
     */
    @RequestMapping("/searchPlanLog")
    public String searchPlan(HttpServletRequest request,@RequestParam Integer pageNumber){
        //从session中获取工作
        Plan plan = (Plan)request.getSession().getAttribute("plan");
        List<PlanLog> logList = plan.getList();
        for(PlanLog planLog :logList){
            logger.info(planLog.toString());
        }
        PageUtil pageUtil = new PageUtil(5,logList.size(),pageNumber);
        pageUtil.setList(logList);
        request.setAttribute("planLogPageUtil",pageUtil);
        return "planLog/planLogInformation";
    }

    /**
     * 下载扶贫日志
     * @param url 扶贫日志地址
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/downLoadPlanLog")
    public String downloadPlanLog(@RequestParam String url, HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            long fileLength = new File(url).length();
            String[] temp = url.split("upload/");
            String fileName = temp[1];
            logger.info("要下载的文件名称："+fileName);
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Length",String.valueOf(fileLength));
            response.setHeader("Content-disposition","attachment;filename=" + new String (fileName.getBytes(),"ISO-8859-1"));
            bis = new BufferedInputStream(new FileInputStream(url));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            //读取文件的偏移量
            int bytesRead;
            while((bytesRead = bis.read(buff,0,buff.length)) != -1){
                bos.write(buff,0,bytesRead);
            }
        }catch (Exception e){
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return null;
    }
}
