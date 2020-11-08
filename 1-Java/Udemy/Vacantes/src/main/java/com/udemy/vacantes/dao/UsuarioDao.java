package com.udemy.vacantes.dao;

import java.sql.Connection;
import com.udemy.vacantes.models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {    
    public Usuario login(String user, String password){
        try(Connection conn = DbConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM Usuarios WHERE username=? AND password =md5(?) AND estatus='activo' LIMIT 1;")){
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            Usuario usuario = null;
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getLong("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setPerfil(rs.getString("perfil"));
                usuario.setEstatus(rs.getString("estatus"));
            }
            rs.close();
            return usuario;
        }catch(SQLException e){
            System.out.println("Error en validar usuario: " + e.getMessage());
            return null;
        }
    }
}
