package SpringJDBCTemplte;

import DbUtils.demo1.Account;
import JDBC.test.utils.JDBCUtils;
import JDBC.test.utils.JDBCUtils2;
import com.alibaba.druid.support.jconsole.util.TableDataProcessor;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Spring template
public class SpringJDBCTemplateDemo {
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils2.getDataSource());

    // 添加数据
    @Test
    public void demo1() {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils2.getDataSource());
        int update = jt.update("insert into dbutils_test values(null,'李四','300')");
        if (update > 0) {
            System.out.println("插入成功");
        }
    }

    // 修改数据
    @Test
    public void demo2() {
        int update = jt.update("update dbutils_test set money = ? where id = ?", "1000", 2);
        System.out.println(update);
    }

    //     删除数据
    @Test
    public void demo3() {
        int update = jt.update("delete from dbutils_test where id = ?", 3);
        if (update > 0) {
            System.out.println("删除成功");
        }
    }

    // 查询单个结果后把结果封装成map
    @Test
    public void demo4() {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils2.getDataSource());
        Map<String, Object> stringObjectMap = jt.queryForMap("select * from dbutils_test where id = ?", 2);
        System.out.println(stringObjectMap);
    }

    // 查询多个结果，然后把结果封装到map list
    @Test
    public void demo5() {
        List<Map<String, Object>> maps = jt.queryForList("select * from dbutils_test");
        System.out.println(maps);
    }

    // 查询多个结果，并放到对应的JavaBean 中（手动书写javabean 实现类）
    @Test
    public void demo6() {
        List<List<Account>> query = jt.query("select * from dbutils_test", new RowMapper<List<Account>>() {
            @Override
            public List<Account> mapRow(ResultSet resultSet, int i) throws SQLException {
                List<Account> list = new ArrayList<>();
                while (resultSet.next()) {
                    Account account = new Account(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("money"));
                    list.add(account);
                }
                return list;
            }
        });
        System.out.println(query);
    }

    // 查询多个结果，并放到对应的JavaBean 中（使用封装好的 javabean实现类）
    @Test
    public void demo7() {
        List<Account> list = jt.query("select * from dbutils_test", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : list) {
            System.out.println(account);
        }
    }

    // 查询总记录数
    @Test
    public void demo8() {
        Long query = jt.queryForObject("select Count(*) from dbutils_test", Long.class);
        System.out.println(query);
    }

    // 查询单列数据
    @Test
    public void demo9 (){
        List<Map<String, Object>> select_name_from_dbutils_test = jt.queryForList("select name from dbutils_test");
        for (Map map : select_name_from_dbutils_test){
            System.out.println(map.get("name"));
        }
    }
}
