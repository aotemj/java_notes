package JDBC.test.prepare_statement_batch;

import JDBC.test.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// JDBC批处理
public class Demo {
    /**
     * 注意，默认mysql 没有开启批处理，需要在配置文件里对DB_URL 后面加上允许批处理 allowMultiQueries=true
     */
    @Test
    public void demo() {
        Connection conn = null;
        PreparedStatement pprst = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            String sql = "insert into jdbc_batch_test2 values(null,?)";

            pprst = conn.prepareStatement(sql);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                pprst.setString(1, "name" + i);
                pprst.addBatch();
                if (i % 1000 == 0) {
                    pprst.executeBatch();
                    pprst.clearBatch();
                }
            }

            long endTime = System.currentTimeMillis();
            long timeDiff = endTime - startTime;
            System.out.println("耗时：" + timeDiff);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(pprst, conn);
        }
    }
}
