package JDBC_dataSource.src.com.datasource.demo1;

import JDBC.test.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    private List<Connection> connList = new ArrayList<Connection>();

    public MyDataSource() {
        init();
    }

    // 获取链接方法
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = connList.remove(0);
        // 增强链接方法
        MyConnectionWrapper mcw = new MyConnectionWrapper(conn, connList);
        return mcw;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    // 连接池初始化
    public void init() {
        for (int i = 0; i < 3; i++) {
            connList.add(JDBCUtils.getConnection());
        }
    }

//    // 添加回收连接池方法
//    public void addBack(Connection conn) {
//        connList.add(conn);
//    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
