package com.eduit.javaseweb.laboratories.laboratory06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDao {
    private static final String INSERT = "INSERT INTO personas (nombre, apellido, edad) VALUES (?,?,?);";
    private static final String UPDATE = "UPDATE personas SET nombre=?, apellido=?, edad=? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM personas WHERE id= ?;";
    private static final String GET = "SELECT id, nombre, apellido, edad FROM personas WHERE id=?;";

    public static void insert(Person person) throws SQLException {
        try (Connection conn = Dao.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, person.getName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getAge());
            ps.execute();
            
            ps.close();
        }
    }
    public static void update(Person person) throws SQLException {
        try (Connection conn = Dao.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setString(1, person.getName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getAge());
            ps.setInt(4, person.getId());
            ps.execute();
            
            ps.close();
        }
    }
    public static void delete(Person person) throws SQLException {
        try (Connection conn = Dao.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(DELETE);
            ps.setInt(1, person.getId());
            ps.execute();            
            ps.close();
        }
    }
    public static Person get(Person person) throws SQLException {
        try (Connection conn = Dao.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(GET);
            ps.setInt(1, person.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                person.setId(rs.getInt("id"));
                person.setAge(rs.getInt("edad"));
                person.setName(rs.getString("nombre"));
                person.setLastName(rs.getString("apellido"));
            }
            
            rs.close();
            ps.close();
            return person;
        }
    }
}