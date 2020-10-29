package com.udemy.gm.services;

import com.udemy.gm.dal.IUsuarioDao;
import com.udemy.gm.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService{

    @Autowired
    private IUsuarioDao dao;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = dao.findByUsername(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no entoncrado");
        }
        
        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
