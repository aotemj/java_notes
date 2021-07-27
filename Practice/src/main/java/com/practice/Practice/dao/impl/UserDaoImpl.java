package com.practice.Practice.dao.impl;

import com.practice.Practice.dao.UserDao;
import com.practice.Practice.domain.User;
import com.practice.Practice.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
//        使用JDBC 操作数据库
//        定义sql
        String sql = "select * from user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";

            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into user values (null,?,?,?,?,?,?,?,?)";
        int number = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getUsername(), user.getPassword());
        if (number > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delUser(int id) {
        String sql = "delete from user where id=?";
        int number = template.update(sql, id);
        if (number > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set name = ?,gender =?,age =?,address =?,qq=?,email=? where id = ?";
        int number = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),user.getId());
        if (number > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from user where id = ?";
        try {
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
