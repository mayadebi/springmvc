package com.fzy.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 实现Controller 就是Controller了
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        String res = "Hello Word";
//        设置数据
        mv.addObject("msg",res);
//        跳转页面
        mv.setViewName("test");
        return mv;
    }
}
