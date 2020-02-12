/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azurecalidaddatos.controllers;

import com.azurecalidaddatos.daos.Conexion;
import com.azurecalidaddatos.daos.DaoCausaIncidente;
import com.azurecalidaddatos.daos.DaoTipoIncidente;
import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.CausaIncidente;
import com.azurecalidaddatos.models.ModeloBase;
import com.azurecalidaddatos.models.ObjetoSistema;
import com.azurecalidaddatos.models.TipoIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K53
 */
public class Main {
    public static void main(String[] args) throws SQLException, BusinessException {
        List<CausaIncidente> modelos = new DaoCausaIncidente().getAll();
        modelos.forEach(modelo -> {
            System.out.println(modelo.getId() + ": " + modelo.getNombre());
        });
        
        ArrayList<ObjetoSistema> modelo2s = new ArrayList<ObjetoSistema>();
        
        TipoIncidente tipo = new TipoIncidente("Hola");
        Connection conn = Conexion.getConnection();
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO ADW.ICD_DIM_TipoIncidente (TipoIncidente) VALUES (?);");
        ps.setString(1, tipo.getNombre());
        ps.execute();
        ps = conn.prepareStatement("SELECT * FROM ADW.ICD_DIM_TipoIncidente WHERE TipoIncidente = ?");
        ps.setString(1, tipo.getNombre());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            tipo.setId(rs.getBigDecimal("ID_TipoIncidente"));
        }
        rs.close();
        ps.close();
        conn.close();
        System.out.println("Tipo: " + tipo.getId() + " Nombre: " + tipo.getNombre());
    }
}
