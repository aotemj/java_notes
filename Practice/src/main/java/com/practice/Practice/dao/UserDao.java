package com.practice.Practice.dao;

import com.practice.Practice.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword (String username,String password);
}
