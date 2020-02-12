package com.eduit.javaspring.clase2.hibernate.dao;

import com.eduit.javaspring.clase2.hibernate.enhanced.PersistenceConfig;
import com.eduit.javaspring.clase2.hibernate.enhanced.model.Empleado;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpleadoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void salvar(Empleado empleado){
        sessionFactory.getCurrentSession().save(empleado);
    }

    public void update(Empleado empleado){
        sessionFactory.getCurrentSession().update(empleado);
    }

    public void delete(Empleado empleado){
        sessionFactory.getCurrentSession().delete(empleado);
    }

    public Empleado get(Long id){
        return sessionFactory.openSession().get(Empleado.class, id);
    }

    public Empleado load(Long id){
        return sessionFactory.openSession().load(Empleado.class, id);
    }
}