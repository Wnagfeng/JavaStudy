package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 加载 MySQL JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 数据库连接 URL，替换为你的数据库信息
            String url = "jdbc:mysql://localhost:3306/cart"; // 替换为你的数据库名
            String user = "root"; // 替换为你的数据库用户名
            String password = "123321"; // 替换为你的数据库密码

            // 创建连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("成功连接到数据库!");

            // 创建 Statement 对象
            stmt = conn.createStatement();

            // 查询数据
            String selectSQL = "SELECT * FROM Bicycle";
            rs = stmt.executeQuery(selectSQL);

            // 打印查询结果
            System.out.println("查询结果:");
            while (rs.next()) {
                int bicycleId = rs.getInt("bicycle_id");
                int batteryLevel = rs.getInt("battery_level");
                int distanceToUser = rs.getInt("distance_to_user");
                System.out.printf("自行车 ID: %d, 电池电量: %d, 距离用户: %d米%n",
                        bicycleId, batteryLevel, distanceToUser);
            }

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 驱动不存在: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("数据库连接失败: " + e.getMessage());
        } finally {
            // 确保结果集、语句和连接被关闭
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) {
                    conn.close();
                    System.out.println("数据库连接已关闭.");
                }
            } catch (SQLException e) {
                System.err.println("关闭连接时发生错误: " + e.getMessage());
            }
        }
    }
}
