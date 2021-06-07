package JDBC.test.JDBCUtils;

import java.sql.*;

public class JDBCUtils {
    static String JDBC_DRIVER;
    static String DB_URL;
    static String USERNAME;
    static String PASSWORD;

    static {
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql:///db4";
        USERNAME = "root";
        PASSWORD = "1234";
    }

    public static void loadDriver() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        loadDriver();
        Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void release(Statement st, Connection conn) {
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

    public static void release(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            rs = null;
        }
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
