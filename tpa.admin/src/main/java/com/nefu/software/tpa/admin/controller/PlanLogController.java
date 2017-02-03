package com.nefu.software.tpa.admin.controller;

import com.nefu.software.tpa.entity.entity.Plan;
import com.nefu.software.tpa.entity.entity.PlanLog;
import com.nefu.software.tpa.user.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 扶贫日志控制层
 *
 * Created by Super腾 on 2017/2/3.
 */
@Controller
public class PlanLogController {

    private static Logger logger = LoggerFactory.getLogger(PlanLogController.class);
    /**
     * 跳至扶贫日志
     * @param pageNumber 当前显示页码
     * @param request 请求
     * @param index 当前属于的扶贫计划编号
     * @return
     */
    @RequestMapping("/toPlanLog")
    public String toPlanLog(@RequestParam Integer pageNumber,HttpServletRequest request, @RequestParam Integer index){
        PageUtil pageUtil = (PageUtil) request.getSession().getAttribute("adminPageUtil");
        List<Plan> list = pageUtil.getList();
        Plan plan = list.get(index);
        List<PlanLog> planLogs = plan.getList();
        PageUtil planLogPageUtil = new PageUtil(5,planLogs.size(),pageNumber);
        planLogPageUtil.setList(planLogs);
        request.setAttribute("planLogPageUtil",planLogPageUtil);
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
