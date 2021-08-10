package com.fzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {
    // 原来的http://localhost:8080/springmvc_04/add?a=1&b=2
    // restful http://localhost:8080/springmvc_04/add/1/2
    @RequestMapping("/add/{a}/{b}")
    public String add(@PathVariable int a,@PathVariable int b, Model model){
        model.addAttribute("msg","结果为:"+(a+b));
        return "test";
    }
}
