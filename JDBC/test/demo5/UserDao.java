package JDBC.test.demo5;

import JDBC.test.utils.JDBCUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
    public boolean login(String username, String password) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection();
            st = conn.createStatement();
            String sql = "select * from jdbc_test where username='" + username + "' and password='" + password + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, st, conn);
        }
        return flag;
    }
}
