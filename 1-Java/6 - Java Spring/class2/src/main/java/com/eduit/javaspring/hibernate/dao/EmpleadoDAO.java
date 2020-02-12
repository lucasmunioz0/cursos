package com.eduit.javaspring.hibernate.dao;

import com.eduit.javaspring.hibernate.enhanced.model.Empleado;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmpleadoDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    public void salvar(Empleado empleado){
        sessionFactory.getCurrentSession().save(empleado);
    }
    public void modificar(Empleado empleado){
        sessionFactory.getCurrentSession().update(empleado);
    }
    public void eliminar(Empleado empleado){
        sessionFactory.getCurrentSession().remove(empleado);
    }
    public Empleado obtener(Empleado empleado){
        //sessionFactory.getCurrentSession().get(empleado);
        
        return null;
    }
}
