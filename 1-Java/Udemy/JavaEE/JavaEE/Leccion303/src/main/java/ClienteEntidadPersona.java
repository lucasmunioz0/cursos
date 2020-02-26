
import com.udemy.javaee.clase303.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        final EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        Persona persona = new Persona("Lucas", "Muñoz", "lmunoz@mail.com", "123123");
        log.debug("Objeto a persistir" + persona);
        em.persist(persona);
        tx.commit();
        log.debug("Objeto persistido" + persona);
        em.close();
    }
}
