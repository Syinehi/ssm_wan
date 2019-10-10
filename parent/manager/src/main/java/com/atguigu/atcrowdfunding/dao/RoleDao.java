package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface RoleDao {

    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);


    void insertPermission(Role role);


    void deleteRole(Integer id);


    void deleteRoles(Map<String, Object> map);

    void update(Role role);

    Role queryById(Integer id);

    @Select("select * from t_role")
    List<Role> queryAll();
}
