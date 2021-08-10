package com.fzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// 加了这个就不会跳页面只会返回字符串
@RestController
public class Json2Controller {
    @RequestMapping("/json2")
    public String jello(Model model){
        return "json2";
    }


}
