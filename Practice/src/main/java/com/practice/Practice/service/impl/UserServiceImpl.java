package com.practice.Practice.service.impl;

import com.practice.Practice.dao.UserDao;
import com.practice.Practice.dao.impl.UserDaoImpl;
import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
//        TODO 调用 DAO 完成查询
        List<User> users = userDao.findAll();
        return users;
    }
}
