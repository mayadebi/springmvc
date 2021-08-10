package com.fzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
    @RequestMapping("/json")
    // 这个方法就会返回字符串
    @ResponseBody
    public String jello(Model model){
        return "json";
    }
}
