package com.udemy.vacantes.dao;

import com.udemy.vacantes.models.Vacante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VacanteDao {

    public Vacante insert(Vacante vacante) {
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Vacantes (fechaPublicacion, nombre, descripcion, detalle)"
                        + " VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(vacante.getFechaPublicacion());
            ps.setString(1, date);
            ps.setString(2, vacante.getNombre());
            ps.setString(3, vacante.getDescripcion());
            ps.setString(4, vacante.getDetalle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                vacante.setId(rs.getLong(1));
            }

            return vacante;
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public List<Vacante> getUltimas(){
        try (Connection conn = DbConnection.getConnection();
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Vacantes ORDER BY idVacante desc LIMIT 3;")) {
            List<Vacante> vacantes = new ArrayList<>(3);
            Vacante vacante;
            while(rs.next()){
                vacante = new Vacante();
                vacante.setId(rs.getLong("idVacante"));
                vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                vacante.setNombre(rs.getString("nombre"));
                vacante.setDescripcion(rs.getString("descripcion"));
                vacante.setDetalle(rs.getString("detalle"));
                vacantes.add(vacante);
            }

            return vacantes;
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public List<Vacante> getAll(){
        try (Connection conn = DbConnection.getConnection();
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM Vacantes ORDER BY idVacante desc;")) {
            List<Vacante> vacantes = new ArrayList<>(3);
            Vacante vacante;
            while(rs.next()){
                vacante = new Vacante();
                vacante.setId(rs.getLong("idVacante"));
                vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                vacante.setNombre(rs.getString("nombre"));
                vacante.setDescripcion(rs.getString("descripcion"));
                vacante.setDetalle(rs.getString("detalle"));
                vacantes.add(vacante);
            }

            return vacantes;
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public List<Vacante> getByQuery(String query){
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Vacantes WHERE (descripcion like ? OR nombre like ?) ORDER BY idVacante desc;");
                ) {
            ps.setString(1, "%" + query + "%");
            ps.setString(2, "%" + query + "%");            
            ResultSet rs = ps.executeQuery();
            List<Vacante> vacantes = new ArrayList<>();
            Vacante vacante;
            while(rs.next()){
                vacante = new Vacante();
                vacante.setId(rs.getLong("idVacante"));
                vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                vacante.setNombre(rs.getString("nombre"));
                vacante.setDescripcion(rs.getString("descripcion"));
                vacante.setDetalle(rs.getString("detalle"));
                vacantes.add(vacante);
            }

            return vacantes;
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public Vacante getById(Long id){
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Vacantes WHERE idVacante=?");) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Vacante vacante = null;
            while(rs.next()){
                vacante = new Vacante();
                vacante.setId(id);
                vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                vacante.setNombre(rs.getString("nombre"));
                vacante.setDescripcion(rs.getString("descripcion"));
                vacante.setDetalle(rs.getString("detalle"));
            }

            rs.close();
            return vacante;
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean delete(Long id){
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM Vacantes WHERE idVacante=?");) {
            ps.setLong(1, id);
            
            return ps.executeUpdate() > 0;            
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public Vacante getById(long id, Connection conn) {
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Vacantes WHERE idVacante=?");) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            Vacante vacante = null;
            while(rs.next()){
                vacante = new Vacante();
                vacante.setId(id);
                vacante.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                vacante.setNombre(rs.getString("nombre"));
                vacante.setDescripcion(rs.getString("descripcion"));
                vacante.setDetalle(rs.getString("detalle"));
            }

            rs.close();
            return vacante;
        } catch (SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
