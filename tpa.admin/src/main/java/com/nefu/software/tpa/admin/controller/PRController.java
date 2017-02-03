package com.nefu.software.tpa.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 帮扶结对类
 *
 * Created by Super腾 on 2017/2/3.
 */
@Controller
public class PRController {

    private static Logger logger = LoggerFactory.getLogger(PRController.class);



    @RequestMapping("/toPR")
    public String toPR(@RequestParam Integer pageNumber){
        return null;
    }
}
