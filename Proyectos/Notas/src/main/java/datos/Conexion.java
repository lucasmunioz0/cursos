/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author lucas
 */
public final class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/igsm?useSSL=false&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static BasicDataSource ds;
    
    private Conexion(){
        
    }
    
    public static synchronized Connection getInstance() throws SQLException{
        if(ds == null){
            loadProperties();
        }
        return ds.getConnection();
    }
    
    private static void loadProperties(){
        ds = new BasicDataSource();
        ds.setUrl(URL);
        ds.setDriverClassName(DRIVER);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.setInitialSize(5);
    }
}
