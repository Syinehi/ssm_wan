package com.atguigu.atcrowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @RequestMapping("/index")
    public String index(){
        return "permission/index";
    }

    @ResponseBody
    @RequestMapping("/loadData")
    public Object loadData(){

    }

}
