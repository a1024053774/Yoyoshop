package com.lanou.yoyoshop.service;

import com.lanou.yoyoshop.bean.User;

public interface IUserService {
    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */

    User getUserByUsername(String username);


    /**
     * 注册用户入库
     * @param user
     * @return
     */
    boolean addUser(User user);


    /**
     *根据用户名和密码获得用户对象
     */
    User getUserByUsernameAndPassword(String username,String password);

    /**
     *
     */
    boolean updateUser(User user);

    /**
     * 根据用户名和电话获取用户对象
     * @param username
     * @param phone
     * @return
     */
    User getUserByUsernameAndPhone(String username,String phone);

    /**
     * 根据id获取用户信息
     * @param userId
     * @return
     */
    User getUserByUserId(Integer userId);
}
