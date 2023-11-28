package StudentManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String userName = "root";
    private static final String password = "123456";

    public static void creatConnect() {
        Connection connection = null;
        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection(URL, userName, password);

        } catch (ClassNotFoundException e) {
            System.out.println("找不到数据库驱动类!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败!");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        creatConnect();
    }
}
