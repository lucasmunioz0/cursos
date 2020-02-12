package com.udemy.controlclientes.datos;

import com.udemy.controlclientes.dominio.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private static final String INSERT = "INSERT INTO clientes(nombre, apellido, email, telefono, saldo) values (?,?,?,?,?);";
    private static final String UPDATE = "UPDATE clientes set nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente =?;";
    private static final String DELETE = "DELETE FROM clientes WHERE id_cliente =?;";
    private static final String GET = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM clientes WHERE id_cliente =?;";
    private static final String GET_ALL = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM clientes;";

    public List<Cliente> getAll() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente;
        Long idCliente;
        String nombre, apellido, email, telefono;
        Double saldo;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                idCliente = rs.getLong("id_cliente");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                email = rs.getString("email");
                telefono = rs.getString("telefono");
                saldo = rs.getDouble("saldo");
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return clientes;
    }

    public Cliente getById(Cliente cliente){
        Long idCliente;
        String nombre, apellido, email, telefono;
        Double saldo;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarStatement(conn, GET, cliente);
                ResultSet rs = ps.executeQuery()) {
            rs.next();
            idCliente = rs.getLong("id_cliente");
            nombre = rs.getString("nombre");
            apellido = rs.getString("apellido");
            email = rs.getString("email");
            telefono = rs.getString("telefono");
            saldo = rs.getDouble("saldo");
            cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
    }

    public Long insert(Cliente cliente) {
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarStatement(conn, INSERT, cliente)) {
             ps.executeUpdate();
             ResultSet rs = ps.getGeneratedKeys();
             rs.next();
             cliente.setId(rs.getLong(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cliente.getId();
    }
    
    public boolean update(Cliente cliente) {
        boolean actualizado = false;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarStatement(conn, UPDATE, cliente)) {
             actualizado = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return actualizado;
    }
    
    public boolean delete(Cliente cliente){
        boolean actualizado = false;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement ps = generarStatement(conn, DELETE, cliente)) {
             actualizado = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return actualizado;
    }

    private static PreparedStatement generarStatement(Connection conn, String sql, Cliente cliente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        switch (sql) {
            case INSERT:
                ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellido());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getTelefono());
                ps.setDouble(5, cliente.getSaldo());
                break;
            case UPDATE:
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellido());
                ps.setString(3, cliente.getEmail());
                ps.setString(4, cliente.getTelefono());
                ps.setDouble(5, cliente.getSaldo());
                ps.setLong(6, cliente.getId());
                break;
            case DELETE: case GET:
                ps.setLong(1, cliente.getId());
                break;
        }
        return ps;
    }
}
