package com.udemy.controlclientes.datos;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    private static DataSource DS;

    public static synchronized Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    private static DataSource getDataSource() {
        if (DS == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl(JDBC_URL);
            ds.setUsername(JDBC_USER);
            ds.setPassword(JDBC_PASSWORD);
            ds.setInitialSize(50);
            DS = ds;
        }

        return DS;
    }
}