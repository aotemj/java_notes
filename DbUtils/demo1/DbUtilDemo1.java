package DbUtils.demo1;

import JDBC.test.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DbUtils 使用
public class DbUtilDemo1 {
    //    新增操作
    @Test
    public void demo1() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        queryRunner.update("insert into dbutils_test values(null,?,?)", "zhangsan", "200");
    }

    // 修改操作
    @Test
    public void demo2() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        queryRunner.update("update dbutils_test set money = ? where id = ?", "1000", 1);
    }

    // 删除操作
    @Test
    public void demo3() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        queryRunner.update("delete from dbutils_test where id = ?", 1);
    }


    // 查询单条数据
    @Test
    public void demo4() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        Account account = queryRunner.query("select * from dbutils_test where id = ?", 2, new ResultSetHandler<Account>() {
            public Account handle(ResultSet rs) throws SQLException {
                Account account = new Account();
                if (rs.next()) {
                    account.setId(rs.getInt("id"));
                    account.setName(rs.getString("name"));
                    account.setMoney(rs.getString("money"));
                }
                return account;
            }
        });
        System.out.println(account);
    }

    //     查询多条数据
    @Test
    public void demo5() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        List<Account> accountList = queryRunner.query("select * from dbutils_test", new ResultSetHandler<List<Account>>() {
            @Override
            public List<Account> handle(ResultSet rs) throws SQLException {
                List<Account> list = new ArrayList<Account>();
                while (rs.next()) {
                    Account account = new Account(rs.getInt("id"), rs.getString("name"), rs.getString("money"));
                    list.add(account);
                }
                return list;
            }
        });
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println(accountList.get(i));
        }
    }
}
