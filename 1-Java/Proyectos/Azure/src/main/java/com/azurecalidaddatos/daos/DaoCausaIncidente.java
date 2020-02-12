package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.CausaIncidente;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCausaIncidente extends DaoBase<CausaIncidente> {

    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_CausaIncidente (CausaIncidente) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_CausaIncidente SET CausaIncidente=? WHERE ID_CausaIncidente=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_CausaIncidente WHERE ID_CausaIncidente=?;";
    private static final String GET_ALL = "SELECT ID_CausaIncidente, CausaIncidente FROM ADW.ICD_DIM_CausaIncidente;";
    private static final String GET_BY_ID = "SELECT ID_CausaIncidente, CausaIncidente FROM ADW.ICD_DIM_CausaIncidente WHERE CausaIncidente=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_CausaIncidente, CausaIncidente FROM ADW.ICD_DIM_CausaIncidente WHERE ID_CausaIncidente like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_CausaIncidente, CausaIncidente FROM ADW.ICD_DIM_CausaIncidente WHERE ID_CausaIncidente = ?;";

    @Override
    public void insert(CausaIncidente causaIncidente, Connection conn) throws SQLException, BusinessException {
        if (causaIncidente.getNombre().trim().equals("")) {
            throw new BusinessException("La causa no puede estar vacía.");
        }

        if (getByNombre(causaIncidente.getNombre().trim()) != null) {
            throw new BusinessException("La causa de incidente ya existe en la base de datos.");
        }

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, INSERT, causaIncidente)) {
            ps.execute();
        }
        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public void update(CausaIncidente causaIncidente, Connection conn) throws SQLException, BusinessException {
        getById(causaIncidente);
        if (causaIncidente.getNombre().trim().equals("")) {
            throw new BusinessException("La causa no puede estar vacía.");
        }
        if (getObjectsByNombre(causaIncidente.getNombre().trim()) != null) {
            throw new BusinessException("La Causa de Incidente ya existe en la base de datos.");
        }

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, causaIncidente)) {
            ps.execute();
        }
        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public void delete(CausaIncidente causaIncidente, Connection conn) throws SQLException, BusinessException {
        getById(causaIncidente);

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, DELETE, causaIncidente)) {
            ps.execute();
        }
        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public List<CausaIncidente> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<CausaIncidente> causasIncidente = new ArrayList<>();
        CausaIncidente find;

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new CausaIncidente();
                find.setId(rs.getBigDecimal("ID_CausaIncidente"));
                find.setNombre(rs.getString("CausaIncidente"));
                causasIncidente.add(find);
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return causasIncidente;
    }

    @Override
    public CausaIncidente getById(CausaIncidente causaIncidente) throws SQLException, BusinessException {
        CausaIncidente find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, causaIncidente);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new CausaIncidente();
                find.setId(rs.getBigDecimal("ID_CausaIncidente"));
                find.setNombre(rs.getString("CausaIncidente"));
            }
        }

        if (find == null) {
            throw new BusinessException("La Causa de Incidente no existe en la base de datos.");
        }

        return find;
    }

    @Override
    public List<CausaIncidente> getAll() throws SQLException, BusinessException {
        List<CausaIncidente> causasIncidente = new ArrayList<>();
        CausaIncidente causaIncidente;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                causaIncidente = new CausaIncidente();
                causaIncidente.setId(rs.getBigDecimal("ID_CausaIncidente"));
                causaIncidente.setNombre(rs.getString("CausaIncidente"));
                causasIncidente.add(causaIncidente);
            }
        }

        return causasIncidente;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, CausaIncidente causaIncidente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, causaIncidente.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1, "%" + causaIncidente.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1, "%" + causaIncidente.getNombre().trim() + "%");
                break;
            case INSERT:
                ps.setString(1, causaIncidente.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, causaIncidente.getNombre().trim());
                ps.setBigDecimal(2, causaIncidente.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, causaIncidente.getId());
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
    public CausaIncidente getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        CausaIncidente find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;

        PreparedStatement ps = localConn.prepareStatement("SELECT ID_CausaIncidente, CausaIncidente FROM ADW.ICD_DIM_CausaIncidente WHERE CausaIncidente =?");
        ps.setString(1, nombre.trim());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            find = new CausaIncidente();
            BigDecimal big = rs.getBigDecimal("ID_CausaIncidente");
            find.setId(big);
            find.setNombre(rs.getString("CausaIncidente"));
        }

        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}
