package com.practice.Practice.service;

import com.practice.Practice.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户名和密码查询用户
     * @return
     */
    public User findUserByUsernameAndPassword (String username,String password);
}
