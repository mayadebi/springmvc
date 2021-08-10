package com.fzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//可以配置方法的类型
@Controller
public class TypeController {
    @GetMapping("/get")
    public String get(){
        return "get";
    }
    @PostMapping("/post")
    public String post(){
        return "post";
    }
    @PutMapping("/put")
    public String put(){
        return "put";
    }
    @DeleteMapping("/delete")
    public String delete(){
        return "delete";
    }
}
