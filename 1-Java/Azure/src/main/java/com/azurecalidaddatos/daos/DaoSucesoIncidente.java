package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.SucesoIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoSucesoIncidente extends DaoBase<SucesoIncidente>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_SucesoIncidente (SucesoIncidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_SucesoIncidente SET SucesoIncidente=? WHERE ID_SucesoIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_SucesoIncidente WHERE ID_SucesoIncidente=?;";
    private static final String GET_ALL = "SELECT ID_SucesoIncidente, SucesoIncidente FROM ADW.ICD_DIM_SucesoIncidente;";
    private static final String GET_BY_ID = "SELECT ID_SucesoIncidente, SucesoIncidente FROM ADW.ICD_DIM_SucesoIncidente WHERE ID_SucesoIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_SucesoIncidente, SucesoIncidente FROM ADW.ICD_DIM_SucesoIncidente WHERE SucesoIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_SucesoIncidente, SucesoIncidente FROM ADW.ICD_DIM_SucesoIncidente WHERE SucesoIncidente = ?;";
    
    @Override
    public void insert(SucesoIncidente sucesoIncidente, Connection conn) throws SQLException, BusinessException {
        if(sucesoIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        
        if(getByNombre(sucesoIncidente.getNombre().trim()) != null)
            throw new BusinessException("El suceso de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, sucesoIncidente)){
            ps.execute();
        }
        if(conn == null)
                localConn.close();
    }

    @Override
    public void update(SucesoIncidente sucesoIncidente, Connection conn) throws SQLException, BusinessException {
        getById(sucesoIncidente);
        if(sucesoIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(sucesoIncidente.getNombre().trim()) != null)
            throw new BusinessException("El suceso de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, sucesoIncidente)){
            ps.execute();
        }
        if(conn == null)
                localConn.close();
    }

    @Override
    public void delete(SucesoIncidente sucesoIncidente, Connection conn) throws SQLException, BusinessException {
        getById(sucesoIncidente);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, sucesoIncidente)){
            ps.execute();
        }
        if(conn == null)
                localConn.close();
    }
    
    @Override
    public List<SucesoIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<SucesoIncidente> sucesosIncidentes = new ArrayList<>();
        SucesoIncidente find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new SucesoIncidente();
                find.setId(rs.getBigDecimal("ID_SucesoIncidente"));
                find.setNombre(rs.getString("SucesoIncidente"));
                sucesosIncidentes.add(find);
            }
        }
        if(conn == null)
                localConn.close();

        return sucesosIncidentes;
    }

    @Override
    public SucesoIncidente getById(SucesoIncidente sucesoIncidente) throws SQLException, BusinessException {
        SucesoIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, sucesoIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new SucesoIncidente();
                find.setId(rs.getBigDecimal("ID_SucesoIncidente"));
                find.setNombre(rs.getString("SucesoIncidente"));
            }
        }
        
        if(find == null)
            throw new BusinessException("El suceso de incidente no existe en la base de datos.");

        return find;
    }
    
    @Override
    public List<SucesoIncidente> getAll() throws SQLException, BusinessException {
        List<SucesoIncidente> sucesosIncidentes = new ArrayList<>();
        SucesoIncidente sucesoIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                sucesoIncidente = new SucesoIncidente();
                sucesoIncidente.setId(rs.getBigDecimal("ID_SucesoIncidente"));
                sucesoIncidente.setNombre(rs.getString("SucesoIncidente"));
                sucesosIncidentes.add(sucesoIncidente);
            }
        }

        return sucesosIncidentes;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, SucesoIncidente sucesoIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, sucesoIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + sucesoIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,sucesoIncidente.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, sucesoIncidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, sucesoIncidente.getNombre().trim());
                ps.setBigDecimal(2, sucesoIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, sucesoIncidente.getId());
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
    public SucesoIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        SucesoIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new SucesoIncidente();
                find.setId(rs.getBigDecimal("ID_SucesoIncidente"));
                find.setNombre(rs.getString("SucesoIncidente"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}