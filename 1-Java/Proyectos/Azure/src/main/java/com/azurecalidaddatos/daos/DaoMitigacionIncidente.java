package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.MitigacionIncidente;
import com.azurecalidaddatos.models.MitigacionIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMitigacionIncidente extends DaoBase<MitigacionIncidente>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_MitigacionIncidente (MitigacionIncidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_MitigacionIncidente SET MitigacionIncidente=? WHERE ID_MitigacionIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_MitigacionIncidente WHERE ID_MitigacionIncidente=?;";
    private static final String GET_ALL = "SELECT ID_MitigacionIncidente, MitigacionIncidente FROM ADW.ICD_DIM_MitigacionIncidente;";
    private static final String GET_BY_ID = "SELECT ID_MitigacionIncidente, MitigacionIncidente FROM ADW.ICD_DIM_MitigacionIncidente WHERE ID_MitigacionIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_MitigacionIncidente, MitigacionIncidente FROM ADW.ICD_DIM_MitigacionIncidente WHERE MitigacionIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_MitigacionIncidente, MitigacionIncidente FROM ADW.ICD_DIM_MitigacionIncidente WHERE MitigacionIncidente = ?;";

    @Override
    public void insert(MitigacionIncidente mitigacionIncidente, Connection conn) throws SQLException, BusinessException {
        if(mitigacionIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        
        if(getByNombre(mitigacionIncidente.getNombre().trim()) != null)
            throw new BusinessException("La mitigación de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, mitigacionIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(MitigacionIncidente mitigacionIncidente, Connection conn) throws SQLException, BusinessException {
        getById(mitigacionIncidente);
        if(mitigacionIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(mitigacionIncidente.getNombre().trim()) != null)
            throw new BusinessException("La mitigación de incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, mitigacionIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(MitigacionIncidente mitigacionIncidente, Connection conn) throws SQLException, BusinessException {
        getById(mitigacionIncidente);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, mitigacionIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<MitigacionIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<MitigacionIncidente> mitigacionesIncidente = new ArrayList<>();
        MitigacionIncidente find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new MitigacionIncidente();
                find.setId(rs.getBigDecimal("ID_MitigacionIncidente"));
                find.setNombre(rs.getString("MitigacionIncidente"));
                mitigacionesIncidente.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return mitigacionesIncidente;
    }

    @Override
    public MitigacionIncidente getById(MitigacionIncidente mitigacionIncidente) throws SQLException, BusinessException {
        MitigacionIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, mitigacionIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new MitigacionIncidente();
                find.setId(rs.getBigDecimal("ID_MitigacionIncidente"));
                find.setNombre(rs.getString("MitigacionIncidente"));
            }
        }
        
        if(find == null)
            throw new BusinessException("La mitigación de incidente no existe en la base de datos.");

        return find;
    }

    @Override
    public List<MitigacionIncidente> getAll() throws SQLException, BusinessException {
        List<MitigacionIncidente> mitigacionesIncidente = new ArrayList<>();
        MitigacionIncidente mitigacionIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                mitigacionIncidente = new MitigacionIncidente();
                mitigacionIncidente.setId(rs.getBigDecimal("ID_MitigacionIncidente"));
                mitigacionIncidente.setNombre(rs.getString("MitigacionIncidente"));
                mitigacionesIncidente.add(mitigacionIncidente);
            }
        }

        return mitigacionesIncidente;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, MitigacionIncidente mitigacionIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, mitigacionIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + mitigacionIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,mitigacionIncidente.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, mitigacionIncidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, mitigacionIncidente.getNombre().trim());
                ps.setBigDecimal(2, mitigacionIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, mitigacionIncidente.getId());
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
    public MitigacionIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        MitigacionIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new MitigacionIncidente();
                find.setId(rs.getBigDecimal("ID_MitigacionIncidente"));
                find.setNombre(rs.getString("MitigacionIncidente"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}