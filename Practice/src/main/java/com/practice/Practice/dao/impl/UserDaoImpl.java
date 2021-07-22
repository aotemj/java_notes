package com.practice.Practice.dao.impl;

import com.practice.Practice.dao.UserDao;
import com.practice.Practice.domain.User;
import com.practice.Practice.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
//        使用JDBC 操作数据库
//        定义sql
        String sql = "select * from user";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }
}
