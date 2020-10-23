package test;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class HolaMundoHibernate {
    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery(hql);
        
        List<Persona> personas = query.getResultList();
        personas.forEach(System.out::println);
    }
    
}
