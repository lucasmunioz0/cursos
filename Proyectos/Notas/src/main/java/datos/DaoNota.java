package datos;

import datos.interfaces.IDaoNota;
import entidades.Nota;
import entidades.Persona;
import entidades.Trimestre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoNota implements IDaoNota {

    private static final String INSERT = "INSERT INTO notas(valor, trimestre, idPersona) VALUES (?,?,?);";
    private static final String UPDATE = "UPDATE notas SET valor=?, trimestre=? WHERE idNota =?;";
    private static final String DELETE = "DELETE FROM notas WHERE idNota =?;";
    private static final String GET_ALL = "SELECT idNota, valor, trimestre, idPersona FROM notas";
    private static final String GET_BY_ID_PERSONA = GET_ALL + " where idPersona = ?;";
    private static final String GET_BY_ID = GET_ALL + " where idNota = ?;";

    @Override
    public List<Nota> getNotasByAlumno(Persona persona) {
        final List<Nota> notas = new ArrayList<>();
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, GET_BY_ID_PERSONA, persona);
                ResultSet rs = ps.executeQuery();) {
            Nota nota;
            while (rs.next()) {
                Long idNota = rs.getLong("idNota");
                Float valor = rs.getFloat("valor");
                Trimestre trimestre = Trimestre.values()[rs.getInt("trimestre")];
                nota = new Nota(idNota, valor, trimestre, persona);
                notas.add(nota);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return notas;
    }

    @Override
    public List<Nota> findAll() {
        final List<Nota> notas = new ArrayList<>();
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = con.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery()) {
            Nota nota;
            while (rs.next()) {
                Long idNota = rs.getLong("idNota");
                Float valor = rs.getFloat("valor");
                Trimestre trimestre = Trimestre.values()[rs.getInt("trimestre")];
                Persona persona = new Persona(rs.getLong("idPersona"));
                nota = new Nota(idNota, valor, trimestre, persona);
                notas.add(nota);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return notas;
    }

    @Override
    public Nota getById(Nota nota) {
        Nota aBuscar = null;
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, GET_BY_ID, nota);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Long idNota = rs.getLong("idNota");
                Float valor = rs.getFloat("valor");
                Trimestre trimestre = Trimestre.values()[rs.getInt("trimestre")];
                Persona persona = new Persona(rs.getLong("idPersona"));
                aBuscar = new Nota(idNota, valor, trimestre, persona);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return aBuscar;
    }

    @Override
    public void insert(Nota nota) {
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, INSERT, nota)){
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            nota.setIdNota(rs.getLong(1));
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void update(Nota nota) {
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, UPDATE, nota)){
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void delete(Nota nota) {
        try (Connection con = Conexion.getInstance();
                PreparedStatement ps = crearPrepared(con, DELETE, nota)){
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    private static PreparedStatement crearPrepared(Connection con, String sql, Nota nota) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);

        switch (sql) {
            case INSERT:
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setFloat(1, nota.getValor());
                ps.setInt(2, nota.getTrimestre().ordinal());
                ps.setLong(3, nota.getPersona().getIdPersona());
                break;
            case UPDATE:
                ps.setFloat(1, nota.getValor());
                ps.setInt(2, nota.getTrimestre().ordinal());
                ps.setLong(3, nota.getIdNota());
                break;
            case DELETE:
            case GET_BY_ID:
                ps.setLong(1, nota.getIdNota());
                break;
            case GET_ALL:
                break;
        }

        return ps;
    }

    private static PreparedStatement crearPrepared(Connection con, String sql, Persona persona) throws SQLException {
        PreparedStatement ps = con.prepareStatement(sql);

        switch (sql) {
            case GET_BY_ID_PERSONA:
                ps.setLong(1, persona.getIdPersona());
                break;
        }
        return ps;
    }

}
