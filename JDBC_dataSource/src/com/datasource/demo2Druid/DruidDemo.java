package JDBC_dataSource.src.com.datasource.demo2Druid;

import JDBC.test.utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo {
    @Test
    // 手动配置
    public void demo1() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DruidDataSource druidDataSource = new DruidDataSource();
        try {
//            conn = JDBCUtils.getConnection();
            druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
            druidDataSource.setUrl("jdbc:mysql:///db5?useSSL=false");
            druidDataSource.setUsername("root");
            druidDataSource.setPassword("1234");
            conn = druidDataSource.getConnection();


            String sql = "select * from jdbc_transaction_test";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");
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

    @Test
    //  自动配置
    public void demo2() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileReader("JDBC_dataSource/src/com/datasource/demo2Druid/druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            conn = ds.getConnection();
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
        }
    }
}
