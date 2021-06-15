package JDBC_dataSource.src.com.datasource.demo1;

import java.sql.Connection;
import java.util.List;

public class MyConnectionWrapper extends ConnectionWrapper {

    private List<Connection> connList;
    private Connection conn = null;

    public MyConnectionWrapper(Connection conn, List<Connection> connList) {
        super(conn);
        this.conn = conn;
        this.connList = connList;
    }

    // 增强某个方法
    @Override
    public void close() {
        connList.add(conn);
    }
}
