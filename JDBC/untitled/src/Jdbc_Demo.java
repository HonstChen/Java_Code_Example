import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Jdbc_Demo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, username, password);

            // 3. 删除表（如果存在）
            String dropTableSql = "DROP TABLE IF EXISTS Cname";
            statement = connection.createStatement();
            statement.executeUpdate(dropTableSql);
            System.out.println("表删除成功");

            // 4. 创建表
            String createTableSql = "CREATE TABLE Cname (id INT, name VARCHAR(20), address VARCHAR(30))";
            statement.executeUpdate(createTableSql);
            System.out.println("表创建成功");
            String insertSql = "INSERT INTO Cname (id, name, address) VALUES ";
            Random random = new Random();
            for (int i = 1; i <= 100; i++) {
                int id = i;
                String name = "Name" + i;
                String address = "Address" + i;
                insertSql += "(" + id + ", '" + name + "', '" + address + "'),";
            }
            insertSql = insertSql.substring(0, insertSql.length() - 1); // 去除最后一个逗号
            statement.executeUpdate(insertSql);
            System.out.println("数据插入成功");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}