package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.ModeloBase;
import com.azurecalidaddatos.models.TipoIncidente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTipoIncidente extends DaoBase<TipoIncidente> {

    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_TipoIncidente (TipoIncidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_TipoIncidente SET TipoIncidente=? WHERE ID_TipoIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_TipoIncidente WHERE ID_TipoIncidente=?;";
    private static final String GET_ALL = "SELECT ID_TipoIncidente, TipoIncidente FROM ADW.ICD_DIM_TipoIncidente;";
    private static final String GET_BY_ID = "SELECT ID_TipoIncidente, TipoIncidente FROM ADW.ICD_DIM_TipoIncidente WHERE ID_TipoIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_TipoIncidente, TipoIncidente FROM ADW.ICD_DIM_TipoIncidente WHERE TipoIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_TipoIncidente, TipoIncidente FROM ADW.ICD_DIM_TipoIncidente WHERE TipoIncidente = ?;";

    @Override
    public void insert(TipoIncidente tipoIncidente, Connection conn) throws SQLException, BusinessException {
        if (tipoIncidente.getNombre().trim().equals("")) {
            throw new BusinessException("El nombre no puede estar vacío.");
        }

        if (getByNombre(tipoIncidente.getNombre().trim()) != null) {
            throw new BusinessException("El Tipo de Incidente ya existe en la base de datos.");
        }

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, INSERT, tipoIncidente)) {
            ps.execute();
        }

        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public void update(TipoIncidente tipoIncidente, Connection conn) throws SQLException, BusinessException {
        getById(tipoIncidente);
        if (tipoIncidente.getNombre().trim().equals("")) {
            throw new BusinessException("El nombre no puede estar vacío.");
        }
        if (getByNombre(tipoIncidente.getNombre().trim()) != null) {
            throw new BusinessException("El Tipo de Incidente ya existe en la base de datos.");
        }

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, tipoIncidente)) {
            ps.execute();
        }

        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public void delete(TipoIncidente tipoIncidente, Connection conn) throws SQLException, BusinessException {
        getById(tipoIncidente);

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, DELETE, tipoIncidente)) {
            ps.execute();
        }

        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public List<TipoIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<TipoIncidente> tiposIncidente = new ArrayList<>();
        TipoIncidente find;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new TipoIncidente();
                find.setId(rs.getBigDecimal("ID_TipoIncidente"));
                find.setNombre(rs.getString("TipoIncidente"));
                tiposIncidente.add(find);
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return tiposIncidente;
    }

    @Override
    public TipoIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        TipoIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new TipoIncidente();
                find.setId(rs.getBigDecimal("ID_TipoIncidente"));
                find.setNombre(rs.getString("TipoIncidente"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }

    @Override
    public TipoIncidente getById(TipoIncidente tipoIncidente) throws SQLException, BusinessException {
        TipoIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, tipoIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new TipoIncidente();
                find.setId(rs.getBigDecimal("ID_TipoIncidente"));
                find.setNombre(rs.getString("TipoIncidente"));
            }
        }

        if (find == null) {
            throw new BusinessException("El Tipo de Incidente no existe en la base de datos.");
        }

        return find;
    }

    @Override
    public List<TipoIncidente> getAll() throws SQLException, BusinessException {
        List<TipoIncidente> tiposIncidentes = new ArrayList<>();
        TipoIncidente tipoIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                tipoIncidente = new TipoIncidente();
                tipoIncidente.setId(rs.getBigDecimal("ID_TipoIncidente"));
                tipoIncidente.setNombre(rs.getString("TipoIncidente"));
                tiposIncidentes.add(tipoIncidente);
            }
        }

        return tiposIncidentes;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, TipoIncidente tipoIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, tipoIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1, "%" + tipoIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1, tipoIncidente.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, tipoIncidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, tipoIncidente.getNombre().trim());
                ps.setBigDecimal(2, tipoIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, tipoIncidente.getId());
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
}
