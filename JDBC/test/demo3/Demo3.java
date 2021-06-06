package JDBC.test.demo3;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo3 {
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql:///db4";
    static String USER = "root";
    static String PASSWORD = "1234";

    @Test
    public void Demo1() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
//        ResultSet rs = null;
        try {
//      注册驱动
            Class.forName(JDBC_DRIVER);
//      建立链接
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            st = conn.createStatement();

            String sql = "insert into jdbc_test values(null,'张三','张三',1)";
//            i: 影响行数
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("更新数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                st = null;
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
