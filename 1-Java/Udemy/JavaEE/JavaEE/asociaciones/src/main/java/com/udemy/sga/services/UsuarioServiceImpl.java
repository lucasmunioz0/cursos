package com.udemy.sga.services;

import com.udemy.sga.dal.UsuarioDao;
import com.udemy.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    private UsuarioDao dao;

    @Override
    public List<Usuario> findAll() {
        return dao.findAll();
    }

    @Override
    public Usuario getById(Usuario usuario) {
        return dao.getById(usuario);
    }

    @Override
    public void insert(Usuario usuario) {
        dao.insert(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        dao.update(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        dao.delete(usuario);
    }    
}