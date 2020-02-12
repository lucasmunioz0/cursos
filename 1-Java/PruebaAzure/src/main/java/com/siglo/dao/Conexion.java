package com.siglo.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://serversqls21-analitica.database.windows.net; "
            + "databaseName=warehouseanalitica";
    private static final String USER = "admins21";
    private static final String PASSWORD = "oVDEzSG2aOXqyGHXi94R";
    private static DataSource ds;
    
    public static synchronized Connection getConnection() throws SQLException{
        if(ds == null){
            loadDataSource();
        }
        return ds.getConnection();
    }

    private static void loadDataSource() {
        BasicDataSource bd = new BasicDataSource();
        bd.setDriverClassName(DRIVER);
        bd.setUrl(URL);
        bd.setUsername(USER);
        bd.setPassword(PASSWORD);
        bd.setInitialSize(5);
        ds = bd;
    }
}