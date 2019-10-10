package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.Role;


import java.util.List;
import java.util.Map;


public interface RoleService {
    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);


    void insertPermission(Role role);

    void deleteRole(Integer id);


    void deleteRoles(Map<String, Object> map);

    void update(Role role);

    Role queryById(Integer id);

    List<Role> queryAll();
}
