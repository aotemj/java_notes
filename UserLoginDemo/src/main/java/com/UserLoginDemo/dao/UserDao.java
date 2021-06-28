package com.UserLoginDemo.dao;

import com.UserLoginDemo.domain.User;
import com.UserLoginDemo.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), loginUser.getUsername(), loginUser.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
