package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class testController {

/*    @RequestMapping("/test")
    public String test(){
        return "login";
    }*/


/*    @Autowired
    private UserService userService;

     @RequestMapping("/test")
     @ResponseBody
     public Object queryAll(){
         List<User> users = userService.queryAll();
         return users;
     }*/
/*
     @ResponseBody
     @RequestMapping("/test2")
     public Object test(Model model){

         return
     }

*/
     /* @RequestMapping("/test2")
      @ResponseBody
      public String result(User user,Model model){

          user = new User("zzz","zzz","zzz","zzz");
          model.addAttribute("user",user);
          return "test/test2";
      }*/
     @ResponseBody
     @RequestMapping("/test")
     public AJAXResult ajaxResult(){
         AJAXResult result = new AJAXResult();
         result.setSuccess(true);
         return result;
     }




}
