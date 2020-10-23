
import com.eduit.academy.entities.Student;
import org.hibernate.service.*;
import org.hibernate.boot.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

    public static void main(String[] args) {
        ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources meta = new MetadataSources(registry);
        Metadata metadata = meta.buildMetadata();
        
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        tx.begin();
        session.save(new Student());
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
