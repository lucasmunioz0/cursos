package com.eduit.javaspring.hibernate.enhanced;

import com.eduit.javaspring.hibernate.dao.EmpleadoDAO;
import com.eduit.javaspring.hibernate.enhanced.model.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);
        
        EmpleadoDAO dao = context.getBean(EmpleadoDAO.class);
        Empleado empleado = new Empleado();
        empleado.setNombre("Lucas");
        
        dao.salvar(empleado);
    }
}
