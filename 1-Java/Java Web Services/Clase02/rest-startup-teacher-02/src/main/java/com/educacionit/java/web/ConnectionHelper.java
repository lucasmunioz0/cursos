package com.educacionit.java.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHelper {

    private String url;
    private String user;
    private String pw;

    private static ConnectionHelper instance;

    private ConnectionHelper() {
        String driver;

        try {
            Properties bundle = new Properties();
            bundle.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
            driver = bundle.getProperty("jdbc.driver");
            Class.forName(driver);
            url = bundle.getProperty("jdbc.url");

            user = bundle.getProperty("jdbc.user");
            pw = bundle.getProperty("jdbc.pw");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new ConnectionHelper();
        }

        try {
            return DriverManager.getConnection(instance.url, instance.user, instance.pw);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}