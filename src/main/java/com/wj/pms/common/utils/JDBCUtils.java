package com.wj.pms.common.utils;

import java.sql.*;

/**
 * JDBC 的工具类 其中包含: 获取数据库连接, 关闭数据库资源等方法.
 * Created by YoungSmith on 2018/8/4.
 */
public class JDBCUtils {

    public static final String oracleDriver = "oracle.jdbc.driver.OracleDriver";
    public static final String mysqlDriver = "com.mysql.jdbc.Driver";

    public static Connection getConnection(String user, String password, String url, String jdbcDriver) throws ClassNotFoundException, SQLException {
        // 2. 加载驱动: Class.forName(driverClass)
        Class.forName(jdbcDriver);

        // 3.获取数据库连接
        Connection connection = DriverManager.getConnection(url, user,
                password);
        return connection;
    }

    public static Connection getConnection(String url) throws ClassNotFoundException, SQLException {
        // 3.获取数据库连接
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }

    public static void driver(String jdbcDriver) {
        // 2. 加载驱动: Class.forName(driverClass)
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void release(Connection connection, PreparedStatement pstmt, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void commit(Connection connection) {
        try {
            if (connection != null)
                connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection connection) {
        try {
            if (connection != null)
                connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}