package com.azurecalidaddatos.daos;

import com.azurecalidaddatos.exceptions.BusinessException;
import com.azurecalidaddatos.models.TicketDerivado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTicketDerivado extends DaoBase<TicketDerivado> {

    private static final String INSERT = "INSERT INTO ADW.ICD_DIM_TicketDerivado (TicketDerivado) VALUES (?);";
    private static final String UPDATE = "UPDATE ADW.ICD_DIM_TicketDerivado SET TicketDerivado=? WHERE ID_TicketDerivado=?;";
    private static final String DELETE = "DELETE FROM ADW.ICD_DIM_TicketDerivado WHERE ID_TicketDerivado=?;";
    private static final String GET_ALL = "SELECT ID_TicketDerivado, TicketDerivado FROM ADW.ICD_DIM_TicketDerivado;";
    private static final String GET_BY_ID = "SELECT ID_TicketDerivado, TicketDerivado FROM ADW.ICD_DIM_TicketDerivado WHERE ID_TicketDerivado=?;";
    private static final String GET_LIKE_NOMBRE = "SELECT ID_TicketDerivado, TicketDerivado FROM ADW.ICD_DIM_TicketDerivado WHERE TicketDerivado like ?;";
    private static final String GET_BY_NOMBRE = "SELECT ID_TicketDerivado, TicketDerivado FROM ADW.ICD_DIM_TicketDerivado WHERE TicketDerivado = ?;";

    @Override
    public void insert(TicketDerivado ticketDerivado, Connection conn) throws SQLException, BusinessException {
        if (ticketDerivado.getNombre().trim().equals("")) {
            throw new BusinessException("El nombre no puede estar vacío.");
        }

        if (getByNombre(ticketDerivado.getNombre().trim()) != null) {
            throw new BusinessException("El ticket derivado ya existe en la base de datos.");
        }

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, INSERT, ticketDerivado)) {
            ps.execute();
        }
        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public void update(TicketDerivado ticketDerivado, Connection conn) throws SQLException, BusinessException {
        getById(ticketDerivado);
        if (ticketDerivado.getNombre().trim().equals("")) {
            throw new BusinessException("El nombre no puede estar vacío.");
        }
        if (getByNombre(ticketDerivado.getNombre().trim()) != null) {
            throw new BusinessException("El ticket derivado ya existe en la base de datos.");
        }

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, UPDATE, ticketDerivado)) {
            ps.execute();
        }
        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public void delete(TicketDerivado ticketDerivado, Connection conn) throws SQLException, BusinessException {
        getById(ticketDerivado);

        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, DELETE, ticketDerivado)) {
            ps.execute();
        }
        if (conn == null) {
            localConn.close();
        }
    }

    @Override
    public List<TicketDerivado> getObjectsByNombre(String nombre, Connection conn) throws SQLException {
        List<TicketDerivado> ticketsDerivados = new ArrayList<>();
        TicketDerivado find;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_LIKE_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new TicketDerivado();
                find.setId(rs.getBigDecimal("ID_TicketDerivado"));
                find.setNombre(rs.getString("TicketDerivado"));
                ticketsDerivados.add(find);
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return ticketsDerivados;
    }

    @Override
    public TicketDerivado getById(TicketDerivado ticketDerivado) throws SQLException, BusinessException {
        TicketDerivado find = null;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarPreparedStatement(conn, GET_BY_ID, ticketDerivado);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new TicketDerivado();
                find.setId(rs.getBigDecimal("ID_TicketDerivado"));
                find.setNombre(rs.getString("TicketDerivado"));
            }
        }

        if (find == null) {
            throw new BusinessException("El ticket derivado no existe en la base de datos.");
        }

        return find;
    }

    @Override
    public List<TicketDerivado> getAll() throws SQLException, BusinessException {
        List<TicketDerivado> ticketsDerivados = new ArrayList<>();
        TicketDerivado ticketDerivado;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ticketDerivado = new TicketDerivado();
                ticketDerivado.setId(rs.getBigDecimal("ID_TicketDerivado"));
                ticketDerivado.setNombre(rs.getString("TicketDerivado"));
                ticketsDerivados.add(ticketDerivado);
            }
        }

        return ticketsDerivados;
    }

    @Override
    public PreparedStatement generarPreparedStatement(Connection conn, String consulta, TicketDerivado ticketDerivado) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(consulta);
        switch (consulta) {
            case GET_BY_ID:
                ps.setBigDecimal(1, ticketDerivado.getId());
                break;
            case GET_LIKE_NOMBRE:
                ps.setString(1, "%" + ticketDerivado.getNombre().trim() + "%");
                break;
            case GET_BY_NOMBRE:
                ps.setString(1, ticketDerivado.getNombre().trim());
                break;
            case INSERT:
                ps.setString(1, ticketDerivado.getNombre().trim());
                break;
            case UPDATE:
                ps.setString(1, ticketDerivado.getNombre().trim());
                ps.setBigDecimal(2, ticketDerivado.getId());
                break;
            case DELETE:
                ps.setBigDecimal(1, ticketDerivado.getId());
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
    public TicketDerivado getByNombre(String nombre, Connection conn) throws SQLException, BusinessException {
        TicketDerivado find = null;
        Connection localConn = conn == null ? Conexion.getConnection() : conn;
        try (PreparedStatement ps = generarPreparedStatement(localConn, GET_BY_NOMBRE, nombre);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                find = new TicketDerivado();
                find.setId(rs.getBigDecimal("ID_TicketDerivado"));
                find.setNombre(rs.getString("TicketDerivado"));
            }
        }
        if (conn == null) {
            localConn.close();
        }

        return find;
    }
}
