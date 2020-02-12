package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.models.SistemaOrigen;
import com.azurecalidaddatos.exceptions.BusinessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoSistemaOrigen extends DaoBase<SistemaOrigen> {

    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_SistemaOrigen (SistemaOrigen) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_SistemaOrigen SET SistemaOrigen=? WHERE ID_SistemaOrigen=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_SistemaOrigen WHERE ID_SistemaOrigen=?;";
    private static final String GET = "SELECT ID_SistemaOrigen, SistemaOrigen FROM ADW.ICD_DIM_SistemaOrigen;";
    private static final String GET_BY_ID = "SELECT ID_SistemaOrigen, SistemaOrigen FROM ADW.ICD_DIM_SistemaOrigen WHERE ID_SistemaOrigen=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_SistemaOrigen, SistemaOrigen FROM ADW.ICD_DIM_SistemaOrigen WHERE SistemaOrigen like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_SistemaOrigen, SistemaOrigen FROM ADW.ICD_DIM_SistemaOrigen WHERE SistemaOrigen = ?;";

    @Override
    public void insert(SistemaOrigen sistema, Connection conn) throws SQLException, BusinessException {
        if(sistema.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");

        if(getByNombre(sistema.getNombre().trim()) != null)
            throw new BusinessException("El Sistema de Origen ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, sistema)){
            ps.execute();
        }
        
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(SistemaOrigen sistema, Connection conn) throws SQLException, BusinessException {
        getById(sistema);
        if(sistema.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(sistema.getNombre().trim()) != null)
            throw new BusinessException("El Sistema de Origen ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, sistema)){
            ps.execute();
        }
        
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(SistemaOrigen sistema, Connection conn) throws SQLException, BusinessException {
        getById(sistema);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, sistema)){
            ps.execute();
        }
        
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<SistemaOrigen> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<SistemaOrigen> sistemas = new ArrayList<>();
        SistemaOrigen find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new SistemaOrigen();
                find.setId(rs.getBigDecimal("ID_SistemaOrigen"));
                find.setNombre(rs.getString("SistemaOrigen"));
                sistemas.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return sistemas;
    }

    @Override
    public SistemaOrigen getById(SistemaOrigen sistema) throws SQLException, BusinessException {
        SistemaOrigen find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, sistema);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new SistemaOrigen();
                find.setId(rs.getBigDecimal("ID_SistemaOrigen"));
                find.setNombre(rs.getString("SistemaOrigen"));
            }
        }
        
        if(find == null)
            throw new BusinessException("El Sistema de Origen no existe en la base de datos.");

        return find;
    }

    @Override
    public List<SistemaOrigen> getAll() throws SQLException {
        List<SistemaOrigen> sistemas = new ArrayList<>();
        SistemaOrigen sistema;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                sistema = new SistemaOrigen();
                sistema.setId(rs.getBigDecimal("ID_SistemaOrigen"));
                sistema.setNombre(rs.getString("SistemaOrigen"));
                sistemas.add(sistema);
            }
        }

        return sistemas;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, SistemaOrigen sistema) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, sistema.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + sistema.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,sistema.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, sistema.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, sistema.getNombre().trim());
                ps.setBigDecimal(2, sistema.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, sistema.getId());
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
    public SistemaOrigen getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        SistemaOrigen find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new SistemaOrigen();
                find.setId(rs.getBigDecimal("ID_SistemaOrigen"));
                find.setNombre(rs.getString("SistemaOrigen"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}
