package datos;

import datos.interfaces.IDaoPersona;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPersona implements IDaoPersona {

    private static final String INSERT = "INSERT INTO personas(nombre, apellido, dni) VALUES (?,?,?);";
    private static final String UPDATE = "UPDATE personas SET nombre=?, apellido=?, dni=?, baja=? WHERE idPersona =?;";
    private static final String DELETE = "DELETE FROM personas WHERE idPersona =?;";
    private static final String GET_ALL = "SELECT idPersona, nombre, apellido, dni, baja FROM personas";
    private static final String GET_BY_ID = GET_ALL +  " WHERE idPersona = ?;";

    @Override
    public List<Persona> findAll() {
        final List<Persona> personas = new ArrayList<>();
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = con.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            Persona persona;
            while (rs.next()) {
                Long id = rs.getLong("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                boolean baja = rs.getBoolean("baja");
                persona = new Persona(id, nombre, apellido, dni, baja);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return personas;
    }

    @Override
    public Persona getById(Persona persona) {
        Persona aBuscar = null;
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, GET_BY_ID, persona);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Long id = rs.getLong("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                boolean baja = rs.getBoolean("baja");
                aBuscar = new Persona(id, nombre, apellido, dni, baja);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return aBuscar;
    }

    @Override
    public void insert(Persona persona) {
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, INSERT, persona)) {
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            persona.setId(rs.getLong(1));
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void update(Persona persona) {
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, UPDATE, persona)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void delete(Persona persona) {
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, DELETE, persona)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    private static PreparedStatement crearPrepared(Connection con, String sql, Persona persona) throws SQLException{
        PreparedStatement ps = con.prepareStatement(sql);
        
        switch (sql) {
            case INSERT:
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getApellido());
                ps.setString(3, persona.getDni());
                break;
            case UPDATE:
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getApellido());
                ps.setString(3, persona.getDni());
                ps.setLong(4, persona.getIdPersona());
                break;
            case DELETE:
            case GET_BY_ID:
                ps.setLong(1, persona.getIdPersona());
                break;
            case GET_ALL:
                break;
        }
        
        return ps;
    }
}
