package com.practice.Practice.dao.impl;

import com.practice.Practice.dao.UserDao;
import com.practice.Practice.domain.PageBean;
import com.practice.Practice.domain.User;
import com.practice.Practice.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        int number = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
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

    @Override
    public List<User> searchByCondition(Map<String, String[]> parameterMap) {
//        TODO 待优化项
        String sql = "select * from user where 1=1";

        StringBuilder sb = new StringBuilder(sql);

        Set<String> keys = parameterMap.keySet();

        List<String> values = new ArrayList();
        for (String key : keys) {
            String value = parameterMap.get(key)[0];
            if (!"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                values.add(value);
            }
        }
        System.out.println("sql = " + sb);
        try {
            return template.query(sql, new BeanPropertyRowMapper<User>(User.class), values);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页获取用户信息
     *
     * @param currentPage 当前页码
     * @param rows        每页数据
     * @return
     */
    @Override
    public PageBean<User> findUsersByPage(int currentPage) {
//        创建空的PageBean 对象
        PageBean pb = new PageBean();
        int rows = pb.getRows();
//        设置当前页面属性和rows属性
        pb.setCurrentPage(currentPage);
//        调用dao查询totalCount 总记录数 dao.findTotalCount();
        int totalCount = this.findTotalCount();
        pb.setTotalCount(totalCount);
//        start = (currentPage -1) * rows
        int start = (currentPage - 1) * rows;
//        调用dao查询list集合 dao.findByPage(int start, int rows);
        List<User> list = this.findByPage(start, rows);
        pb.setList(list);
//        计算总页码
        int totalPage = ((totalCount % rows) == 0) ? (totalCount / rows) : (int) (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    /**
     * 获取所有记录数
     *
     * @return
     */
    @Override
    public int findTotalCount() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql, Integer.class);
    }

    /**
     * 分页查询
     *
     * @param start
     * @param rows
     * @return
     */
    public List<User> findByPage(int start, int rows) {
        String sql = "select * from user limit ?,?";
        try {
            List<User> query = template.query(sql, new BeanPropertyRowMapper<>(User.class), start, rows);
            return query;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
