package JDBC_dataSource.src.com.datasource.demo3C3P0;

import JDBC.test.utils.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C3P0Demo {
    // 手动配置
    @Test
    public void demo1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql:///db5?useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("1234");

            conn = dataSource.getConnection();
            String sql = "select * from jdbc_transaction_test";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String money = rs.getString("money");
                System.out.print("ID: " + id);
                System.out.print(" name: " + name);
                System.out.print(" money: " + money);
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, ps, conn);
        }
    }
}
