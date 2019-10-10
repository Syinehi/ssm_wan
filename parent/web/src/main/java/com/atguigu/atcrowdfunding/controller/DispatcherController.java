package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DispatcherController {
    @Autowired
    private UserService userService;




    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:login";
    }

    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session){
        AJAXResult result = new AJAXResult();
        User dbUser = userService.query4login(user);
        session.setAttribute("loginUser",dbUser);
        if (dbUser != null){
            result.setSuccess(true);
        }else{
            result.setSuccess(false);
        }
        return result;
    }

    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model){
        String  loginaccount = user.getLoginaccount();

        //1)获取表单数据
        //1-1) HttpServletRequest
        //1-2) 在方法参数列表中添加表单对应的参数,名称相同
        //1-3) 就是将表单数据封装为实体类对象

        //2) 查询用户信息
        User dbUser = userService.query4login(user);
        //3) 判断是否有数据
        if (dbUser !=  null){
            //登录成功,跳转主页面
            return "main";
        }else {
            //登入失败,跳转回登录页面,提示错误信息
            String errorMsg =  "登入账号或密码不正确,请重新输入!!";
            model.addAttribute("errorMsg",errorMsg);
            return "redirect:login";
        }

    }
}
