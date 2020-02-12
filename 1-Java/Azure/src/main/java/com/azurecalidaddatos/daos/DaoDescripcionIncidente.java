package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.DescripcionIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDescripcionIncidente extends DaoBase<DescripcionIncidente>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_DescripcionIncidente (DescripcionIncidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_DescripcionIncidente SET DescripcionIncidente=? WHERE ID_DescripcionIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_DescripcionIncidente WHERE ID_DescripcionIncidente=?;";
    private static final String GET_ALL = "SELECT ID_DescripcionIncidente, DescripcionIncidente FROM ADW.ICD_DIM_DescripcionIncidente;";
    private static final String GET_BY_ID = "SELECT ID_DescripcionIncidente, DescripcionIncidente FROM ADW.ICD_DIM_DescripcionIncidente WHERE ID_DescripcionIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_DescripcionIncidente, DescripcionIncidente FROM ADW.ICD_DIM_DescripcionIncidente WHERE DescripcionIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_DescripcionIncidente, DescripcionIncidente FROM ADW.ICD_DIM_DescripcionIncidente WHERE DescripcionIncidente = ?;";

    @Override
    public void insert(DescripcionIncidente descripcionIncidente, Connection conn) throws SQLException, BusinessException {
        if(descripcionIncidente.getNombre().trim().equals(""))
            throw new BusinessException("La descripción no puede estar vacía.");
        
        if(getByNombre(descripcionIncidente.getNombre().trim()) != null)
            throw new BusinessException("La descripción de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, descripcionIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(DescripcionIncidente descripcionIncidente, Connection conn) throws SQLException, BusinessException {
        getById(descripcionIncidente);
        if(descripcionIncidente.getNombre().trim().equals(""))
            throw new BusinessException("La descripción no puede estar vacía.");
        if(getByNombre(descripcionIncidente.getNombre().trim()) != null)
            throw new BusinessException("La descripción de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, descripcionIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(DescripcionIncidente descripcionIncidente, Connection conn) throws SQLException, BusinessException {
        getById(descripcionIncidente);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, descripcionIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<DescripcionIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<DescripcionIncidente> descripcionesIncidente = new ArrayList<>();
        DescripcionIncidente find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new DescripcionIncidente();
                find.setId(rs.getBigDecimal("ID_DescripcionIncidente"));
                find.setNombre(rs.getString("DescripcionIncidente"));
                descripcionesIncidente.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return descripcionesIncidente;
    }

    @Override
    public DescripcionIncidente getById(DescripcionIncidente descripcionIncidente) throws SQLException, BusinessException {
        DescripcionIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, descripcionIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new DescripcionIncidente();
                find.setId(rs.getBigDecimal("ID_DescripcionIncidente"));
                find.setNombre(rs.getString("DescripcionIncidente"));
            }
        }
        
        if(find == null)
            throw new BusinessException("La descripción de incidente no existe en la base de datos.");

        return find;
    }

    @Override
    public List<DescripcionIncidente> getAll() throws SQLException, BusinessException {
        List<DescripcionIncidente> descripcionesIncidente = new ArrayList<>();
        DescripcionIncidente descripcionIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                descripcionIncidente = new DescripcionIncidente();
                descripcionIncidente.setId(rs.getBigDecimal("ID_DescripcionIncidente"));
                descripcionIncidente.setNombre(rs.getString("DescripcionIncidente"));
                descripcionesIncidente.add(descripcionIncidente);
            }
        }

        return descripcionesIncidente;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, DescripcionIncidente descripcionIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, descripcionIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + descripcionIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,descripcionIncidente.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, descripcionIncidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, descripcionIncidente.getNombre().trim());
                ps.setBigDecimal(2, descripcionIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, descripcionIncidente.getId());
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
    public DescripcionIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        DescripcionIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new DescripcionIncidente();
                find.setId(rs.getBigDecimal("ID_DescripcionIncidente"));
                find.setNombre(rs.getString("DescripcionIncidente"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}