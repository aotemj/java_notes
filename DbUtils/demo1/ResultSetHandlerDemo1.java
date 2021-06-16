package DbUtils.demo1;

import JDBC.test.utils.JDBCUtils2;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import javax.management.Query;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ResultSetHandler
 */
public class ResultSetHandlerDemo1 {
    // ResultSetArray(单条数据)
    @Test
    public void demo1() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        Object[] o = queryRunner.query("select * from dbutils_test where id = ?", new ArrayHandler(), 2);
        System.out.println(Arrays.toString(o)); // [2, zhangsan, 200]
    }


    //    ResultSetArrayList(多条数据)
    @Test
    public void demo2() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        List<Object[]> list = queryRunner.query("select * from dbutils_test", new ArrayListHandler());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }

    // BeanHandler(单条数据)
    @Test
    public void demo3() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        Account account = queryRunner.query("select * from dbutils_test where id = ?", new BeanHandler<Account>(Account.class), 2);
        System.out.println(account); // Account{id=2, name='zhangsan', money='200'}
    }

    //     BeanListHandler(多条数据)
    @Test
    public void demo4() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        List<Account> list = queryRunner.query("select * from dbutils_test", new BeanListHandler<Account>(Account.class));
        for (Account account : list) {
            System.out.println(account);
        }
    }

    //    MapHandler(单条数据)
    @Test
    public void demo5() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        Map<String, Object> query = queryRunner.query("select * from dbutils_test where id = ?", new MapHandler(), 2);
        System.out.println(query); //{money=200, name=zhangsan, id=2}
    }

    //    MapListHandler(多条数据)
    @Test
    public void demo6() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
        List<Map<String, Object>> mapList = queryRunner.query("select * from dbutils_test", new MapListHandler());
        for (Map<String, Object> map : mapList) {
            System.out.println(map);
        }
    }
}
