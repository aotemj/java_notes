package com.practice.Practice.service.impl;

import com.practice.Practice.dao.UserDao;
import com.practice.Practice.dao.impl.UserDaoImpl;
import com.practice.Practice.domain.User;
import com.practice.Practice.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
//        TODO 调用 DAO 完成查询
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = userDao.findUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean delUser(int id) {
        return userDao.delUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void delUsers(String[] ids) {
        for (String id : ids) {
            userDao.delUser(Integer.parseInt(id));
        }
    }

    @Override
    public List<User> searchByCondition(Map<String, String[]> parameterMap) {
        return userDao.searchByCondition(parameterMap);
    }
}
