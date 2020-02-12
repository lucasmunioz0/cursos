package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.EstadoIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEstadoIncidente extends DaoBase<EstadoIncidente>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_EstadoIncidente (EstadoIncidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_EstadoIncidente SET EstadoIncidente=? WHERE ID_EstadoIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_EstadoIncidente WHERE ID_EstadoIncidente=?;";
    private static final String GET_ALL = "SELECT ID_EstadoIncidente, EstadoIncidente FROM ADW.ICD_DIM_EstadoIncidente;";
    private static final String GET_BY_ID = "SELECT ID_EstadoIncidente, EstadoIncidente FROM ADW.ICD_DIM_EstadoIncidente WHERE ID_EstadoIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_EstadoIncidente, EstadoIncidente FROM ADW.ICD_DIM_EstadoIncidente WHERE EstadoIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_EstadoIncidente, EstadoIncidente FROM ADW.ICD_DIM_EstadoIncidente WHERE EstadoIncidente = ?;";

    @Override
    public void insert(EstadoIncidente estadoIncidente, Connection conn) throws SQLException, BusinessException {
        if(estadoIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        
        if(getByNombre(estadoIncidente.getNombre().trim()) != null)
            throw new BusinessException("Es estado de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, estadoIncidente)){
            ps.execute();
        }
    }

    @Override
    public void update(EstadoIncidente estadoIncidente, Connection conn) throws SQLException, BusinessException {
        getById(estadoIncidente);
        if(estadoIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(estadoIncidente.getNombre().trim()) != null)
            throw new BusinessException("Es estado de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, estadoIncidente)){
            ps.execute();
        }
    }

    @Override
    public void delete(EstadoIncidente estadoIncidente, Connection conn) throws SQLException, BusinessException {
        getById(estadoIncidente);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, estadoIncidente)){
            ps.execute();
        }
    }
    
    @Override
    public List<EstadoIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<EstadoIncidente> estadosIncidente = new ArrayList<>();
        EstadoIncidente find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new EstadoIncidente();
                find.setId(rs.getBigDecimal("ID_EstadoIncidente"));
                find.setNombre(rs.getString("EstadoIncidente"));
                estadosIncidente.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return estadosIncidente;
    }

    @Override
    public EstadoIncidente getById(EstadoIncidente estadoIncidente) throws SQLException, BusinessException {
        EstadoIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, estadoIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new EstadoIncidente();
                find.setId(rs.getBigDecimal("ID_EstadoIncidente"));
                find.setNombre(rs.getString("EstadoIncidente"));
            }
        }
        
        if(find == null)
            throw new BusinessException("Es estado de incidente no existe en la base de datos.");

        return find;
    }

    @Override
    public List<EstadoIncidente> getAll() throws SQLException, BusinessException {
        List<EstadoIncidente> estadosIncidente = new ArrayList<>();
        EstadoIncidente estadoIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                estadoIncidente = new EstadoIncidente();
                estadoIncidente.setId(rs.getBigDecimal("ID_EstadoIncidente"));
                estadoIncidente.setNombre(rs.getString("EstadoIncidente"));
                estadosIncidente.add(estadoIncidente);
            }
        }

        return estadosIncidente;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, EstadoIncidente estadoIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, estadoIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + estadoIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,estadoIncidente.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, estadoIncidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, estadoIncidente.getNombre().trim());
                ps.setBigDecimal(2, estadoIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, estadoIncidente.getId());
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
    public EstadoIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        EstadoIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new EstadoIncidente();
                find.setId(rs.getBigDecimal("ID_EstadoIncidente"));
                find.setNombre(rs.getString("EstadoIncidente"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}