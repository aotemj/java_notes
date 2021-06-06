package JDBC.test.demo1;

import java.sql.*;

public class Demo2 {
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/db4?SSL=false";
    static String USER = "root";
    static String PASSWORD = "1234";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            //        加载驱动
            Class.forName(JDBC_DRIVER);
            //        链接数据
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = conn.createStatement();
            //        查询SQL
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
            //        释放资源 (标准写法)
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
