package JDBC.test.prepareStatementDemo;

import JDBC.test.utils.JDBCUtils;
import org.junit.Test;

import java.sql.*;

public class Demo {

    // 保存操作
    @Test
    public void demo1() {
        Connection conn = null;
        PreparedStatement ppst = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into jdbc_test values(null,?,?,?,?)";
            ppst = conn.prepareStatement(sql);

            ppst.setString(1, "lisilisi");
            ppst.setString(2, "lisi");
            ppst.setInt(3, 12);
            ppst.setString(4, "12312");
            int i = ppst.executeUpdate();
            if (i > 0) {
                System.out.println("保存成功");
            } else {
                System.out.println("保存失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(ppst, conn);
        }
    }

    //更新操作
    @Test
    public void demo2() {
        Connection conn = null;
        PreparedStatement pprst = null;

        try {

            conn = JDBCUtils.getConnection();
            String sql = "update jdbc_test set username = ?,nickname = ?,age = ? where id = 4";
            pprst = conn.prepareStatement(sql);

            pprst.setString(1, "lis");
            pprst.setString(2, "liss");
            pprst.setInt(3, 14);
            int i = pprst.executeUpdate();
            if (i > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pprst, conn);
        }
    }

    // 删除操作
    @Test
    public void demo3() {
        Connection conn = null;
        PreparedStatement pprst = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from jdbc_test where id = ?";
            pprst = conn.prepareStatement(sql);
            pprst.setInt(1, 4);
            int i = pprst.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pprst, conn);
        }
    }

    //    读
    @Test
    public void demo4() {
        Connection conn = null;
        PreparedStatement pprst = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from jdbc_test where username = ? and nickname = ?";
            pprst = conn.prepareStatement(sql);
            pprst.setString(1, "张三");
            pprst.setString(2, "张三");
            rs = pprst.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String nickname = rs.getString("nickname");
                int age = rs.getInt("age");
                System.out.print("username: " + username + " ");
                System.out.print("nickname: " + nickname + " ");
                System.out.print("age: " + age + " ");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, pprst, conn);
        }
    }
}
