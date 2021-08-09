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

    /**
     * 分页获取用户信息
     *
     * @param currentPage1  当前页码
     * @param parameterMap
     * @return
     */
    @Override
    public PageBean<User> findUsersByPage(String currentPage1, Map<String, String[]> parameterMap) {
//        创建空的PageBean 对象
        PageBean pb = new PageBean();
        int rows = pb.getRows();
        int currentPage = Integer.parseInt(currentPage1) | 1;
//        设置当前页面属性和rows属性
        pb.setCurrentPage(currentPage);
//        调用dao查询totalCount 总记录数 dao.findTotalCount();

        int totalCount = this.findTotalCount(parameterMap);
        pb.setTotalCount(totalCount);
//        start = (currentPage -1) * rows
        int start = (currentPage - 1) * rows;
//        调用dao查询list集合 dao.findByPage(int start, int rows);
        List<User> list = this.findByPage(start, rows, parameterMap);
        pb.setList(list);
//        计算总页码
        int totalPage = ((totalCount % rows) == 0) ? (totalCount / rows) : (int) (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }

    /**
     * 获取所有记录数
     *
     * @param parameterMap
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> parameterMap) {
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> conditions = parameterMap.keySet();
        List<String> values = new ArrayList<>();
        for (String condition : conditions) {
            String value = parameterMap.get(condition)[0];
            if (condition.equals("currentPage") || condition.equals("rows")) {
                continue;
            }
            if (!"".equals(value)) {
                sb.append(" and " + condition + " like ? ");
                values.add("%" + value + "%");
            }

        }

        return template.queryForObject(sb.toString(), Integer.class, values.toArray());
    }

    /**
     * 分页查询
     *
     * @param start
     * @param rows
     * @param parameterMap
     * @return
     */
    public List<User> findByPage(int start, int rows, Map<String, String[]> parameterMap) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> conditions = parameterMap.keySet();
        List<Object> values = new ArrayList<>();
        for (String condition : conditions) {
            if (condition.equals("start") || condition.equals("rows") || condition.equals("currentPage")) {
                continue;
            }

            String value = parameterMap.get(condition)[0];
            if (!"".equals(value)) {
                sb.append(" and " + condition + " like ? ");
                values.add("%" + value + "%");
            }
        }
        sb.append(" limit ? , ? ");
        values.add(start);
        values.add(rows);
        try {
            List<User> query = template.query(sb.toString(), new BeanPropertyRowMapper<>(User.class), values.toArray());
            return query;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
