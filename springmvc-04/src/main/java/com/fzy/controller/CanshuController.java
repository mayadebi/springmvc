package com.fzy.controller;

import com.alibaba.fastjson.JSON;
import com.fzy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CanshuController {
    // 提交参数名字一样可以直接接受
    // 不一样就用RequestParam  加了这个就必须要传这个参数不然报错
    // 也可以直接传对象
    @RequestMapping("/canshu")
    public String canshu(String name, @RequestParam("username") String name1, User user){
        System.out.println(name);
        System.out.println(name1);
        System.out.println(user.toString());
        return "canshu";
    }
    // 多个参数使用RequestParam+map接受  必须加RequestParam  用RequestBody也可以试试
    @RequestMapping("/canshu1")
    public String canshu1(@RequestParam Map<String,Object> map){
        System.out.println(map.toString());
        String s = JSON.toJSONString(map);
        System.out.println(s);
        Map<String,Object> map2 = JSON.parseObject(s);
        System.out.println(map2.toString());
        return "canshu";
    }

    @RequestMapping("/canshu2")
    public String canshu2(@RequestParam Map<String,Object> map){
        System.out.println(map.toString());
        return "canshu";
    }
}
