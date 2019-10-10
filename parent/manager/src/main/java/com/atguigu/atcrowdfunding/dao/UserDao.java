package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserDao {


    @Select("select * from t_user")
    public List<User> queryAll();

    @Select("select * from t_user where loginaccount = #{loginaccount} and userpassword = #{userpassword}")
    User query4login(User user);

    List<User> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    void insertUser(User user);

    @Select("select * from t_user where id = #{id}")
    User queryById(Integer id);

    void updateUser(User user);

    @Delete("delete from t_user where id = #{id}")
    void deleteUserById(Integer id);

    void deleteUsers(Map<String, Object> map);

    void insertUserRoles(Map<String, Object> map);

    void deleteUserRoles(Map<String, Object> map);

    @Select("select roleid from t_user_role where userid = #{userid}")
    List<Integer> queryRoleidsByUserid(Integer id);
}
