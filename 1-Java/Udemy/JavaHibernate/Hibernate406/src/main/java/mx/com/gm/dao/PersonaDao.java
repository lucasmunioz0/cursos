package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class PersonaDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDao() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }

    public List<Persona> getAll() {
        Query query = em.createQuery("SELECT p FROM Persona p");
        return query.getResultList();
    }

    public void insert(Persona persona) {
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.persist(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            t.rollback();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public void update(Persona persona){
        EntityTransaction t = em.getTransaction();
        try {
            t.begin();
            em.merge(persona);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
            t.rollback();
        }
    }

    public Persona get(long id) {
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.idPersona = :id", Persona.class);
        query.setParameter("id", id);
        return (Persona) query.getSingleResult();
    }

}
