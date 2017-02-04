package com.nefu.software.tpa.user.util;

import com.nefu.software.tpa.entity.entity.ReliefCompany;
import com.nefu.software.tpa.entity.entity.ReliefPerson;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *拦截所有未登录请求
 * Created by Super腾 on 2017/2/4.
 */
public class MyHandler implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        ReliefPerson reliefPerson = (ReliefPerson) httpServletRequest.getSession().getAttribute("reliefPerson");
        ReliefCompany reliefCompany  = (ReliefCompany) httpServletRequest.getSession().getAttribute("reliefCompany");
        if(reliefPerson == null && reliefCompany == null){
            httpServletResponse.sendRedirect("http://localhost:8080/");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
