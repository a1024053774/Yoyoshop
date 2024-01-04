package com.lanou.yoyoshop.dao;

import com.lanou.yoyoshop.bean.User;

public interface IUserDao {
    /**
     * 根据用户名查表获取User对象
     * @param username
     * @return
     */
    User selectUserByUsername(String username);


    /**
     * 插入用户
     * @param user
     * @return
     */
    boolean insertUser(User user);

    /**
     *通过用户名和密码查询用户
     */
    User selectUserByUsernameAndPassword(String username,String password);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 通过用户名和电话查询用户
     * @param username
     * @param phone
     * @return
     */
    User selectUserByUsernameAndPhone(String username,String phone);

    /**
     * 根据id获取用户信息
     * @param userId
     * @return
     */
    User selectUserByUserId(Integer userId);
}
