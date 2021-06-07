package JDBC.test.demo4;

import JDBC.test.JDBCUtils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

public class Demo4 {
    @Test
    public void Demo1() {
        Connection conn = null;
        Statement st = null;
        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(st, conn);
        }
    }
}
