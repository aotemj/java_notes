package JDBC.test.demo5;

//SQL 注入演示
public class demo5 {
    public static void main(String[] args) {
        UserDao ud = new UserDao();
//        SQL 注入示例1： 将 username 改成 `用户名 ' or '1=1``密码随意
//        boolean flag = ud.login("张三 ' or '1=1", "1231231");

//        SQL 注入示例2： 将username 改成 `用户名 '--`,密码随意
        boolean flag = ud.login("张三' -- ", "123123123");
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
