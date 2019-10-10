package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Page;
import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/update")
    public Object update(Role role){
        AJAXResult result = new AJAXResult();
        try {
            roleService.update(role);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteRoles")
    public Object deleteRoles(Integer[] roleids){
        AJAXResult result =new AJAXResult();
        try{
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("roleids",roleids);
            roleService.deleteRoles(map);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteRole")
    public Object deleteRole(Integer id){
        AJAXResult result = new AJAXResult();
        try {
            roleService.deleteRole(id);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Object insertPermission(Role role){
        AJAXResult result = new AJAXResult();
        try {
            roleService.insertPermission(role);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;

    }

    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(Integer pageno,Integer pagesize,String queryTest){
        AJAXResult result = new AJAXResult();

        try {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("start",(pageno-1)*pagesize);
            map.put("size",pagesize);
            map.put("queryTest",queryTest);
            List<Role> roles = roleService.pageQueryData(map);
            //总的数据条数
            int totalsize  = roleService.pageQueryCount(map);
            //最大页码(总页码)
            int totalno = 0;
            if (totalsize % pagesize == 0){
                totalno = totalsize / pagesize;
            }else {
                totalno = totalsize / pagesize + 1;
            }
            Page<Role> rolepage = new Page<Role>();
            rolepage.setPageno(pageno);
            rolepage.setTotalsize(totalsize);
            rolepage.setTotalno(totalno);
            rolepage.setDatas(roles);

            result.setData(rolepage);
            result.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }


    @RequestMapping("/gotoRoleIndex")
    public String gotoRoleIndex(){
        return "role/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "role/index";
    }

    @RequestMapping("/add")
    public String add(){
        return "role/add";
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id") Integer id, Model model){
        Role role = roleService.queryById(id);
        model.addAttribute("role",role);
        return "role/edit";
    }

}
