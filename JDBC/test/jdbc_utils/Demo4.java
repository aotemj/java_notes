package JDBC.test.jdbc_utils;

import JDBC.test.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo4 {
    @Test
    public void Demo1() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            String sql = "select * from jdbc_test";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String nickname = rs.getString("nickname");
                int age = rs.getInt("age");
                System.out.print("ID: " + id + " ");
                System.out.print("username: " + username + " ");
                System.out.print("nickname: " + nickname + " ");
                System.out.print("age: " + age + " ");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, st, conn);
        }
    }
}
