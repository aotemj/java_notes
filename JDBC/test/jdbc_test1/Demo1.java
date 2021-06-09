package JDBC.test.jdbc_test1;

import java.sql.*;

// JDBC
public class Demo1 {

    //     驱动名，数据库url
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db4"; // 本机可省略为： "jdbc:mysql:///db4"

    static final String USER = "root";
    static final String PASSWORD = "1234";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//         1.加载驱动
        Class.forName(JDBC_DRIVER);
//         2.获取链接
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//         3.基本操作 执行SQL
//         3.1 获取执行SQL语句的对象
        Statement statement = conn.createStatement();
//         3.2 编写SQL 语句
        String sql1 = "select * from jdbc_test";
//        3.3 执行SQL,获取结果集（rs）;
        ResultSet rs = statement.executeQuery(sql1);
//        3.4 遍历结果集
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String nickname = rs.getString("nickname");
            int age = rs.getInt("age");
            System.out.print("ID: " + id + " ");
            System.out.print("姓名: " + username + " ");
            System.out.print("昵称: " + nickname + " ");
            System.out.print("年龄: " + age + " ");
            System.out.println("");
        }
//         释放资源
        rs.close();
        statement.close();
        conn.close();
    }
}
