package com.eduit.javaspring.clase2.hibernate.enhanced;

import com.eduit.javaspring.clase2.hibernate.dao.EmpleadoDAO;
import com.eduit.javaspring.clase2.hibernate.enhanced.model.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class);

        final EmpleadoDAO bean = context.getBean(EmpleadoDAO.class);

        Empleado empleado = new Empleado();
        empleado.setNombre("Lucas");

        bean.salvar(empleado);

        empleado.setNombre("Martin");
        bean.update(empleado);

        Empleado empleado1 = bean.get(empleado.getId());
        System.out.println(empleado1.getNombre());
        System.out.println(empleado1.getId());

        bean.delete(empleado);
        System.out.println("Borrado con éxito");
        empleado = bean.get(empleado.getId());
        if(empleado == null){
            bean.salvar(empleado1);
        }
        empleado = bean.get(empleado.getId());
        System.out.println(empleado.getNombre());
        System.out.println(empleado.getId());
        System.out.println("Finalizado insert");
    }
}