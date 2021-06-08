package JDBC.test.demo5;

import JDBC.test.utils.JDBCUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
    // 存在SQL 注入漏洞的登录流程
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

    public boolean loginWithPrePared(String username, String password) {
        Connection conn = null;
        PreparedStatement prpst = null;
        ResultSet rs = null;
        boolean flag = false;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from jdbc_test where username = ? and password = ?";
//             编译当前SQL 语句
            prpst = conn.prepareStatement(sql);
            prpst.setString(1, username);
            prpst.setString(2, password);

            rs = prpst.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, prpst, conn);
        }
        return flag;
    }
}
