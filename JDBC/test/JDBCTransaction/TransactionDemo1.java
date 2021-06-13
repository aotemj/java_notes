package JDBC.test.JDBCTransaction;

import JDBC.test.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

//jdbc 事务管理
public class TransactionDemo1 {
    @Test
    public void demo1() {
        Connection conn = null;
        PreparedStatement ppst = null;
        try {
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            String sql = "update jdbc_transaction_test set money = money + ? where id = ?";
            ppst = conn.prepareStatement(sql);
            ppst.setDouble(1, 100);
            ppst.setInt(2, 1);
            int i = 2 / 0;
            ppst.executeUpdate();
            ppst.setDouble(1, -100);
            ppst.setInt(2, 2);
            ppst.executeUpdate();
            // 提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.release(ppst, conn);
        }
    }
}
