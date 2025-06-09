package com.americano;

import com.americano.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {

//    JDBC入门程序
    @Test
    public void testUpdate() throws Exception {
//      1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

//      2.获取数据库链接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "212414";
        Connection connection = DriverManager.getConnection(url, username, password);
//      3.获取SQL语句执行对象
        Statement statement = connection.createStatement();

//      4.执行SQL
        int i = statement.executeUpdate("update user set age = 25 where id = 1");//用于执行DML（增删改）语句, 会返回一个int值代表受到影响的行数
        System.out.println("SQL执行完毕后影响的记录数为： " + i);

//      5. 释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testQuery() throws Exception {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {

            //1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2. 获取连接
            String url = "jdbc:mysql://localhost:3306/web01";
            String username = "root";
            String password = "212414";
            connection = DriverManager.getConnection(url, username, password);

            //3. 获取PreparedStatement对象
            String sql = "select id,username,password,name,age from user where username = ? and password = ?"; // 预编译SQL，性能更好：存在缓存里，可复用，编译一次；安全性更好：避免SQL注入；代码可读性更好
            pstmt = connection.prepareStatement(sql);

            //4. 设置参数
            pstmt.setString(1, "daqiao");
            pstmt.setString(2, "123456");

            //5. 执行SQL查询
            resultSet = pstmt.executeQuery();//用于执行DQL（查询）语句

            //6. 处理结果
            while (resultSet.next()) { // 行光标下移
                //获取数据
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String user = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                int age = resultSet.getInt("age");

                //封装User对象
                User u = new User(id, user, pwd, name, age);
                System.out.println(u);
            }
        } finally {
            //7. 释放资源
            resultSet.close();
            pstmt.close();
            connection.close();
        }
    }
}
