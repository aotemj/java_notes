package com.practice.Practice.service;

import com.practice.Practice.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户名和密码查询用户
     *
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 删除用户
     *
     * @param id 待删除用户id
     * @return
     */
    public boolean delUser(int id);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 通过id获取用户信息
     */
    public User getUserById(int id);
}
