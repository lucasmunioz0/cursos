package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.ObjetoSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoObjetoSistema extends DaoBase<ObjetoSistema>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_ObjetoSistema (ObjetoSistema) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_ObjetoSistema SET ObjetoSistema=? WHERE ID_ObjetoSistema=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_ObjetoSistema WHERE ID_ObjetoSistema=?;";
    private static final String GET_ALL = "SELECT ID_ObjetoSistema, ObjetoSistema FROM ADW.ICD_DIM_ObjetoSistema;";
    private static final String GET_BY_ID = "SELECT ID_ObjetoSistema, ObjetoSistema FROM ADW.ICD_DIM_ObjetoSistema WHERE ID_ObjetoSistema=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_ObjetoSistema, ObjetoSistema FROM ADW.ICD_DIM_ObjetoSistema WHERE ObjetoSistema like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_ObjetoSistema, ObjetoSistema FROM ADW.ICD_DIM_ObjetoSistema WHERE ObjetoSistema = ?;";

    @Override
    public void insert(ObjetoSistema objetoSistema, Connection conn) throws SQLException, BusinessException {
        if(objetoSistema.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        
        if(getByNombre(objetoSistema.getNombre().trim()) != null)
            throw new BusinessException("El objeto de sistema ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, objetoSistema)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(ObjetoSistema objetoSistema, Connection conn) throws SQLException, BusinessException {
        getById(objetoSistema);
        if(objetoSistema.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(objetoSistema.getNombre().trim()) != null)
            throw new BusinessException("El objeto de sistema ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, objetoSistema)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(ObjetoSistema objetoSistema, Connection conn) throws SQLException, BusinessException {
        getById(objetoSistema);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, objetoSistema)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<ObjetoSistema> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<ObjetoSistema> objetosSistema = new ArrayList<>();
        ObjetoSistema find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new ObjetoSistema();
                find.setId(rs.getBigDecimal("ID_ObjetoSistema"));
                find.setNombre(rs.getString("ObjetoSistema"));
                objetosSistema.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return objetosSistema;
    }

    @Override
    public ObjetoSistema getById(ObjetoSistema objetoSistema) throws SQLException, BusinessException {
        ObjetoSistema find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, objetoSistema);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new ObjetoSistema();
                find.setId(rs.getBigDecimal("ID_ObjetoSistema"));
                find.setNombre(rs.getString("ObjetoSistema"));
            }
        }
        
        if(find == null)
            throw new BusinessException("El objeto de sistema no existe en la base de datos.");

        return find;
    }

    @Override
    public List<ObjetoSistema> getAll() throws SQLException, BusinessException {
        List<ObjetoSistema> objetosSistemas = new ArrayList<>();
        ObjetoSistema objetoSistema;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                objetoSistema = new ObjetoSistema();
                objetoSistema.setId(rs.getBigDecimal("ID_ObjetoSistema"));
                objetoSistema.setNombre(rs.getString("ObjetoSistema"));
                objetosSistemas.add(objetoSistema);
            }
        }

        return objetosSistemas;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, ObjetoSistema objetoSistema) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, objetoSistema.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + objetoSistema.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,objetoSistema.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, objetoSistema.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, objetoSistema.getNombre().trim());
                ps.setBigDecimal(2, objetoSistema.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, objetoSistema.getId());
                break;
        }
        
        return ps;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, String nombre) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        ps.setString(1, "%" + nombre.trim() + "%");
        return ps;
    }    

    @Override
    public ObjetoSistema getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        ObjetoSistema find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new ObjetoSistema();
                find.setId(rs.getBigDecimal("ID_ObjetoSistema"));
                find.setNombre(rs.getString("ObjetoSistema"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}