package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.FacIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoFacIncidente extends DaoBase<FacIncidente>{
    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_FacIncidentes (FechaIncidente, ID_SistemaOrigen, ID_TipoIncidente"
            + "         , ID_ObjetoSistema, ID_SucesoIncidente, ID_Incidente, ID_CausaIncidente, ID_DescripcionIncidente, ID_MitigacionIncidente"
            + "         , ID_TicketDerivado, ID_EstadoIncidente, ID_Informador, Cant_Incidente) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_FacIncidente SET FacIncidente=? WHERE ID_FacIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_FacIncidente WHERE ID_FacIncidente=?;";
    private static final String GET_ALL = "SELECT ID_FacIncidente, FacIncidente FROM ADW.ICD_DIM_FacIncidente;";
    private static final String GET_BY_ID = "SELECT ID_FacIncidente, FacIncidente FROM ADW.ICD_DIM_FacIncidente WHERE ID_FacIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_FacIncidente, FacIncidente FROM ADW.ICD_DIM_FacIncidente WHERE FacIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_FacIncidente, FacIncidente FROM ADW.ICD_DIM_FacIncidente WHERE FacIncidente = ?;";

    @Override
    public void insert(FacIncidente facIncidente, Connection conn) throws SQLException, BusinessException {        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, INSERT, facIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void update(FacIncidente facIncidente, Connection conn) throws SQLException, BusinessException {
        getById(facIncidente);
        if(facIncidente.getNombre().trim().equals(""))
            throw new BusinessException("El nombre no puede estar vacío.");
        if(getByNombre(facIncidente.getNombre().trim()) != null)
            throw new BusinessException("El facIncidente ya existe en la base de datos.");
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, facIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }

    @Override
    public void delete(FacIncidente facIncidente, Connection conn) throws SQLException, BusinessException {
        getById(facIncidente);
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try(PreparedStatement ps = generarPreparedStatement(localConn, DELETE, facIncidente)){
            ps.execute();
        }
        if(conn == null)
            localConn.close();
    }
    
    @Override
    public List<FacIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<FacIncidente> facIncidentes = new ArrayList<>();
        FacIncidente find;
        
        Connection localConn = conn == null? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new FacIncidente();
                find.setId(rs.getBigDecimal("ID_FacIncidente"));
                find.setNombre(rs.getString("FacIncidente"));
                facIncidentes.add(find);
            }
        }
        if(conn == null)
            localConn.close();

        return facIncidentes;
    }

    @Override
    public FacIncidente getById(FacIncidente facIncidente) throws SQLException, BusinessException {
        FacIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, facIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new FacIncidente();
                find.setId(rs.getBigDecimal("ID_FacIncidente"));
                find.setNombre(rs.getString("FacIncidente"));
            }
        }
        
        if(find == null)
            throw new BusinessException("El facIncidente no existe en la base de datos.");

        return find;
    }

    @Override
    public List<FacIncidente> getAll() throws SQLException, BusinessException {
        List<FacIncidente> facIncidentess = new ArrayList<>();
        FacIncidente facIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                facIncidente = new FacIncidente();
                facIncidente.setId(rs.getBigDecimal("ID_FacIncidente"));
                facIncidente.setNombre(rs.getString("FacIncidente"));
                facIncidentess.add(facIncidente);
            }
        }

        return facIncidentess;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, FacIncidente facIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, facIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1,"%" + facIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1,"%" + facIncidente.getNombre().trim() + "%");
                break;
            case INSERT:
                ps.setObject(1, facIncidente.getFechaIncidente());
                ps.setBigDecimal(2, facIncidente.getSistemaOrigen().getId());
                ps.setBigDecimal(3, facIncidente.getTipoIncidente().getId());
                ps.setBigDecimal(4, facIncidente.getObjetoSistema().getId());
                ps.setBigDecimal(5, facIncidente.getSucesoIncidente().getId());
                ps.setBigDecimal(6, facIncidente.getIncidente().getId());
                ps.setBigDecimal(7, facIncidente.getCausaIncidente().getId());
                ps.setBigDecimal(8, facIncidente.getDescripcionIncidente().getId());
                ps.setBigDecimal(9, facIncidente.getMitigacionIncidente().getId());
                ps.setBigDecimal(10, facIncidente.getTicketDerivado().getId());
                ps.setBigDecimal(11, facIncidente.getEstadoIncidente().getId());
                ps.setBigDecimal(12, facIncidente.getInformador().getId());
                ps.setInt(13, facIncidente.getCantidad());
                break;
            case UPDATE:
                ps.setString(1, facIncidente.getNombre().trim());
                ps.setBigDecimal(2, facIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, facIncidente.getId());
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
    public FacIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        FacIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new FacIncidente();
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