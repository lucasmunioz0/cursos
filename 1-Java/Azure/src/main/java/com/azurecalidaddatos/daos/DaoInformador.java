package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.Informador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoInformador extends DaoBase<Informador>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_Informador (Informador) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_Informador SET Informador=? WHERE ID_Informador=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_Informador WHERE ID_Informador=?;";
    private static final String GET_ALL = "SELECT ID_Informador, Informador FROM ADW.ICD_DIM_Informador;";
    private static final String GET_BY_ID = "SELECT ID_Informador, Informador FROM ADW.ICD_DIM_Informador WHERE ID_Informador=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_Informador, Informador FROM ADW.ICD_DIM_Informador WHERE Informador like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_Informador, Informador FROM ADW.ICD_DIM_Informador WHERE Informador = ?;";

    @Override
    public void insert(Informador informador, Connection conn) throws SQLException, BusinessException {
        if(informador.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        
        if(getByNombre(informador.getNombre().trim()) != null)
            throw new BusinessException("El informador ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, informador)){
            ps.execute();
        }
        
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(Informador informador, Connection conn) throws SQLException, BusinessException {
        getById(informador);
        if(informador.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(informador.getNombre().trim()) != null)
            throw new BusinessException("El informador ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, informador)){
            ps.execute();
        }
        
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(Informador informador, Connection conn) throws SQLException, BusinessException {
        getById(informador);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, informador)){
            ps.execute();
        }
        
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<Informador> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<Informador> informadores = new ArrayList<>();
        Informador find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new Informador();
                find.setId(rs.getBigDecimal("ID_Informador"));
                find.setNombre(rs.getString("Informador"));
                informadores.add(find);
            }
        }

        if(conn == null)
            localConn.close();
        return informadores;
    }

    @Override
    public Informador getById(Informador informador) throws SQLException, BusinessException {
        Informador find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, informador);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new Informador();
                find.setId(rs.getBigDecimal("ID_Informador"));
                find.setNombre(rs.getString("Informador"));
            }
        }
        
        if(find == null)
            throw new BusinessException("El informador no existe en la base de datos.");

        return find;
    }

    @Override
    public List<Informador> getAll() throws SQLException, BusinessException {
        List<Informador> informadores = new ArrayList<>();
        Informador informador;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                informador = new Informador();
                informador.setId(rs.getBigDecimal("ID_Informador"));
                informador.setNombre(rs.getString("Informador"));
                informadores.add(informador);
            }
        }

        return informadores;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, Informador informador) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, informador.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + informador.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,informador.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, informador.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, informador.getNombre().trim());
                ps.setBigDecimal(2, informador.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, informador.getId());
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
    public Informador getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        Informador find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new Informador();
                find.setId(rs.getBigDecimal("ID_Informador"));
                find.setNombre(rs.getString("Informador"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}