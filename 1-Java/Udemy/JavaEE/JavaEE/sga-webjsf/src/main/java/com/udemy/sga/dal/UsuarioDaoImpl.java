package com.udemy.sga.dal;

import com.udemy.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
    @PersistenceContext(unitName = "SgaPU")
    EntityManager em;

    @Override
    public List<Usuario> findAll() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario getById(Usuario usuario) {
        Query query = em.createNamedQuery("Usuario.findByIdUsuario");
        query.setParameter("idUsuario", usuario.getIdUsuario());
        return (Usuario) query.getSingleResult();
    }

    @Override
    public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        em.remove(em.merge(usuario));
    }    
}