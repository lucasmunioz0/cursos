package com.azurecalidaddatos.daos;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Conexion {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://serversqls21-analitica.database.windows.net;"
            + "databaseName=warehouseanalitica";
    private static final String USER = "admins21";
    private static final String PASSWORD = "oVDEzSG2aOXqyGHXi94R";
    private static DataSource ds;

    private Conexion() {
    }

    public static Connection getConnection() throws SQLException {
        if (ds == null) {
            SQLServerDataSource bs = new SQLServerDataSource();
            bs.setServerName("serversqls21-analitica.database.windows.net");
            bs.setDatabaseName("warehouseanalitica");
            bs.setUser("admins21");
            bs.setPassword("oVDEzSG2aOXqyGHXi94R");
//            bs.setDriverClassName(DRIVER);
//            bs.setUrl(URL);
//            bs.setUsername(USER);
//            bs.setPassword(PASSWORD);
            ds = bs;
        }

        return ds.getConnection();
    }
}