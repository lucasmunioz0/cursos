package com.eduit.javaseweb.laboratories.laboratory06;

import com.eduit.javaseweb.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
    public static Connection getConnection() throws SQLException{
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/javaseweb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "admin";
        
        return ConnectionManager.getConnectionManager(driver, url, user, password).getConnection();
    }
}
