/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.vacantes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.udemy.vacantes.models.Solicitud;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class SolicitudDao {

    public Solicitud insert(Solicitud solicitud) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Solicitudes VALUES (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {
            ps.setLong(1, solicitud.getId());
            ps.setString(2, format.format(solicitud.getFecha()));
            ps.setString(3, solicitud.getNombre());
            ps.setString(4, solicitud.getEmail());
            ps.setString(5, solicitud.getTelefono());
            ps.setString(6, solicitud.getDireccion());
            ps.setString(7, solicitud.getArchivo());
            ps.setLong(8, solicitud.getVacante().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            Long idSolicitud = 0L;
            if (rs.next()) {
                solicitud.setId(rs.getLong(1));
            }

            return solicitud;
        } catch (SQLException e) {
            System.out.println("Error SolicitudDao.insert: " + e.getMessage());
            return null;
        }
    }

    public List<Solicitud> getAll() {
        try (Connection conn = DbConnection.getConnection();
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Solicitudes ORDER BY idSolicitud DESC;")) {
            List<Solicitud> list = new ArrayList<>();
            Solicitud solicitud;
            VacanteDao vacanteDao = new VacanteDao();
            
            while (rs.next()) {
                solicitud = new Solicitud(rs.getLong("idSolicitud"));
                solicitud.setFecha(rs.getDate("fecha"));
                solicitud.setNombre(rs.getString("nombre"));
                solicitud.setEmail(rs.getString("email"));
                solicitud.setTelefono(rs.getString("telefono"));
                solicitud.setDireccion(rs.getString("direccion"));
                solicitud.setArchivo(rs.getString("archivo"));
                solicitud.setVacante(vacanteDao.getById(rs.getLong("idVacante"), conn));
                list.add(solicitud);
            }
            rs.close();
            return list;

        } catch (SQLException e) {
            System.out.println("Error SolicitudDao.getAll: " + e.getMessage());
            return null;
        }
    }
}
