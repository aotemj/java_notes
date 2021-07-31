package com.practice.Practice.dao;

import com.practice.Practice.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public boolean addUser(User user);

    public boolean delUser(int id);

    public boolean updateUser(User user);

    public User getUserById(int id);

    public List<User> searchByCondition(Map<String, String[]> parameterMap);
}
