package com.fzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//可以在整个controller上面加个路径   一般不用
@RequestMapping("/test")
public class HelloController {
    @RequestMapping("/hello")
    public String jello(Model model){
        // 保存数据
        model.addAttribute("msg","hello word");
        return "hello";
    }
}
