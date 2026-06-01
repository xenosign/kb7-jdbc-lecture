package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/kb7-jdbc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public JDBCUtil() {};

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }

}
