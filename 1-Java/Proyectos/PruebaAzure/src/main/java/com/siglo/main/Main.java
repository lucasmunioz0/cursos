package com.siglo.main;

import com.siglo.dao.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = Conexion.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM ADW.ICD_DIM_SistemaOrigen");
        int idSistema;
        String sistema;
        while(rs.next()){
            idSistema = rs.getInt("ID_SistemaOrigen");
            sistema = rs.getString("SistemaOrigen");
            System.out.printf("\nId: %d - Sistema: %s", idSistema, sistema);
        }
        rs.close();
        //insertTest();
        rs = statement.executeQuery("SELECT * FROM ADW.ICD_DIM_SistemaOrigen");
        
        while(rs.next()){
            idSistema = rs.getInt("ID_SistemaOrigen");
            sistema = rs.getString("SistemaOrigen");
            System.out.printf("\nId: %d - Sistema: %s", idSistema, sistema);
        }
        
    }
    
    private static void insertTest() throws SQLException{
        Connection conn = Conexion.getConnection();
        Statement statement = conn.createStatement();
        boolean itsOk = statement.execute("INSERT INTO ADW.ICD_DIM_SistemaOrigen (SistemaOrigen) VALUES ('SistemaPrueba');");
        System.out.println(itsOk);
        statement.close();
        conn.close();
    }
}
