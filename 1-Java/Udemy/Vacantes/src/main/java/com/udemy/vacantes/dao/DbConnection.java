package com.udemy.vacantes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    static String username = "root";
    private static String password = "Arc40172091$";
    private static String url = "jdbc:mysql://localhost:3306/rrhh?useSSL=false&serverTimezone=UTC";
    private static DbConnection instance;

    private static Connection conn = null;

    private DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Conexión database [" + conn + "] OK");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al obtener conexión: " + ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null || conn == null || conn.isClosed()) {
            instance = new DbConnection();
        }
        return conn;
    }
}
