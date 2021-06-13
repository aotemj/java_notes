package JDBC_dataSource.src.com.datasource.demo1;

import JDBC.test.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义连接池测试类
 */
public class DataSourceDemo1 {
    @Test
    public void demo1() throws SQLException {
        Connection conn = null;
        PreparedStatement ppst = null;
        ResultSet rs = null;
        MyDataSource dataSource = new MyDataSource();
        try {
            conn = dataSource.getConnection();
            String sql = "select * from jdbc_transaction_test";
            ppst = conn.prepareStatement(sql);
            rs = ppst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String money = rs.getString("money");
                System.out.print("ID: " + id + " ");
                System.out.print("name: " + name + " ");
                System.out.print("money: " + money + " ");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if (ppst != null) {
                try {
                    ppst.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ppst = null;
            }
            dataSource.addBack(conn);
        }
    }
}
