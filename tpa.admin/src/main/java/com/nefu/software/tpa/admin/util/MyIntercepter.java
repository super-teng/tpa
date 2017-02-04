package com.nefu.software.tpa.admin.util;

import com.nefu.software.tpa.entity.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器用于拦截未登录请求
 * Created by Super腾 on 2017/2/4.
 */
public class MyIntercepter implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(MyIntercepter.class);
    /**
     * 当用户没有登录的时候退回登录页面
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("进入了！！");
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("admin");
        if(admin == null){
            httpServletResponse.sendRedirect("http://localhost:8080/admin");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
