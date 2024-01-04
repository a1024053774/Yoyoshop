package com.lanou.yoyoshop.service.impl;

import com.lanou.yoyoshop.bean.User;
import com.lanou.yoyoshop.dao.IUserDao;
import com.lanou.yoyoshop.dao.impl.UserDaoImpl;
import com.lanou.yoyoshop.service.IUserService;

public class UserServiceImpl implements IUserService {
    private IUserDao userDao = new UserDaoImpl();
    @Override
    public User getUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userDao.selectUserByUsernameAndPassword(username,password);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUserByUsernameAndPhone(String username, String phone) {
        return userDao.selectUserByUsernameAndPhone(username,phone);
    }

    @Override
    public User getUserByUserId(Integer userId) {
        return userDao.selectUserByUserId(userId);
    }


}
