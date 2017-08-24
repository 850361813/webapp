package com.baidu.fpd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Create by zhaoxianghui on 2017/8/24.
 */

public class FreemarkerController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr
                                             , HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("title", "Spring MVC And Freemarker");
        mv.addObject("content", " Hello world ， test my first spring mvc ! ");
        return mv;
    }
}
