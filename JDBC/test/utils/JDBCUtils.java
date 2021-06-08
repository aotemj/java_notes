package JDBC.test.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static final String JDBC_DRIVER;
    private static final String DB_URL;
    private static final String USERNAME;
    private static final String PASSWORD;


    static {
        Properties prop = new Properties();
        try {
            FileReader fileReader = new FileReader("JDBC/test/utils/db.properties");
            prop.load(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
        DB_URL = prop.getProperty("DB_URL");
        USERNAME = prop.getProperty("USER");
        PASSWORD = prop.getProperty("PASSWORD");
    }

    public static void loadDriver() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            loadDriver();
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public static void release(ResultSet rs, PreparedStatement st, Connection conn) {
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
