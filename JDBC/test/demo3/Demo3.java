package JDBC.test.demo3;

import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo3 {
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql:///db4";
    static String USER = "root";
    static String PASSWORD = "1234";

    //    插入数据
    @Test
    public void Demo1() throws ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
//        ResultSet rs = null;
        try {
//      注册驱动
            Class.forName(JDBC_DRIVER);
//      建立链接
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            st = conn.createStatement();

            String sql = "insert into jdbc_test values(null,'张三','张三',1)";
//            i: 影响行数
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("更新数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    //    修改数据
    @Test
    public void Demo2() {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = conn.createStatement();
            String sql = "update jdbc_test set nickname = '张三1' where id = 4";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("数据修改完成");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    //     删除数据
    @Test
    public void Demo3() {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = conn.createStatement();
            String sql = "delete from jdbc_test where id = 4";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            }
        }
    }

    //      查询数据（单条）
    @Test
    public void Demo4() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            st = conn.createStatement();
            String sql = "select * from jdbc_test where id = 1";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String nickname = rs.getString("nickname");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + " username: " + username + " nickname:" + nickname + " age:" + age);
                System.out.println("查询成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
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
