package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.Incidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoIncidente extends DaoBase<Incidente>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_Incidente (Incidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_Incidente SET Incidente=? WHERE ID_Incidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_Incidente WHERE ID_Incidente=?;";
    private static final String GET_ALL = "SELECT ID_Incidente, Incidente FROM ADW.ICD_DIM_Incidente;";
    private static final String GET_BY_ID = "SELECT ID_Incidente, Incidente FROM ADW.ICD_DIM_Incidente WHERE ID_Incidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_Incidente, Incidente FROM ADW.ICD_DIM_Incidente WHERE Incidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_Incidente, Incidente FROM ADW.ICD_DIM_Incidente WHERE Incidente = ?;";

    @Override
    public void insert(Incidente incidente, Connection conn) throws SQLException, BusinessException {
        if(incidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        
        if(getByNombre(incidente.getNombre().trim()) != null)
            throw new BusinessException("El incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, incidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(Incidente incidente, Connection conn) throws SQLException, BusinessException {
        getById(incidente);
        if(incidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(incidente.getNombre().trim()) != null)
            throw new BusinessException("El incidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, incidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(Incidente incidente, Connection conn) throws SQLException, BusinessException {
        getById(incidente);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, incidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<Incidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<Incidente> incidentes = new ArrayList<>();
        Incidente find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new Incidente();
                find.setId(rs.getBigDecimal("ID_Incidente"));
                find.setNombre(rs.getString("Incidente"));
                incidentes.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return incidentes;
    }

    @Override
    public Incidente getById(Incidente incidente) throws SQLException, BusinessException {
        Incidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, incidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new Incidente();
                find.setId(rs.getBigDecimal("ID_Incidente"));
                find.setNombre(rs.getString("Incidente"));
            }
        }
        
        if(find == null)
            throw new BusinessException("El incidente no existe en la base de datos.");

        return find;
    }

    @Override
    public List<Incidente> getAll() throws SQLException, BusinessException {
        List<Incidente> incidentess = new ArrayList<>();
        Incidente incidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                incidente = new Incidente();
                incidente.setId(rs.getBigDecimal("ID_Incidente"));
                incidente.setNombre(rs.getString("Incidente"));
                incidentess.add(incidente);
            }
        }

        return incidentess;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, Incidente incidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, incidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + incidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,incidente.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, incidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, incidente.getNombre().trim());
                ps.setBigDecimal(2, incidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, incidente.getId());
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
    public Incidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        Incidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new Incidente();
                find.setId(rs.getBigDecimal("ID_Incidente"));
                find.setNombre(rs.getString("Incidente"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}