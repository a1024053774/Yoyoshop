package com.lanou.yoyoshop.dao.impl;

import com.lanou.yoyoshop.bean.User;
import com.lanou.yoyoshop.dao.IUserDao;
import com.lanou.yoyoshop.util.DBUtils;

public class UserDaoImpl implements IUserDao {
    @Override
    public User selectUserByUsername(String username) {
        User user = DBUtils.queryOne("select * from user where username = ?", User.class, username);
        return user;
    }

    @Override
    public boolean insertUser(User user) {
        //查表使用query，其他使用update
        int update = DBUtils.update("insert into user(username,password,name,phone,address) values (?,?,?,?,?)", user.getUsername(), user.getPassword(), user.getName(), user.getPhone(), user.getAddress());

        return update >= 1;
    }

    @Override
    public User selectUserByUsernameAndPassword(String username, String password) {
        User user = DBUtils.queryOne("select * from user where username = ? and password = ? ", User.class, username, password);
        return user;

    }

    @Override
    public boolean updateUser(User user) {
        int update = DBUtils.update("update user set username=?,password=?,name=?,phone=?,address=? where id=?", user.getUsername(), user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.getId());
        return update >= 1;

    }

    @Override
    public User selectUserByUsernameAndPhone(String username, String phone) {
        User user = DBUtils.queryOne("select * from user where username = ? and phone = ? ", User.class, username, phone);
        return user;
    }

    @Override
    public User selectUserByUserId(Integer userId) {
        User user = DBUtils.queryOne("select * from user where id = ?",User.class,userId);
        return user;
    }


}
