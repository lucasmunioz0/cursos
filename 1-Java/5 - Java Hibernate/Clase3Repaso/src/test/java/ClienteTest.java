
import com.eduit.clase3.entities.Cliente;
import com.eduit.clase3.manager.SessionFactoryManager;
import com.eduit.clase3.repository.ClienteRepository;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

    private SessionFactory sessionFactory;
    private ClienteRepository clienteRepository;

    @Before
    public void before() {
        System.err.println("ENTRANDO AL BEFORE");
        sessionFactory = SessionFactoryManager.getSessionFactory();
        clienteRepository = new ClienteRepository(sessionFactory);
    }

    @Test
    public void shouldSaveCliente() {

        Cliente cliente = new Cliente("Lucas", "Muñoz", 5000D);
        Long id = clienteRepository.save(cliente);
        Cliente clienteRecuperado = clienteRepository.getById(id);
        Assert.assertEquals("Lucas", clienteRecuperado.getNombre());
        Assert.assertEquals("Muñoz", clienteRecuperado.getApellido());
        Assert.assertEquals(new Double(5000), clienteRecuperado.getCredito());
    }

    @Test
    public void shouldGetAllClients() {
        Cliente cliente1 = new Cliente("Lucas", "Muñoz", 5000D);
        Cliente cliente2 = new Cliente("Martin", "Castro", 3000D);
        Long id1 = clienteRepository.save(cliente1);
        Long id2 = clienteRepository.save(cliente2);

        cliente1 = clienteRepository.getById(id1);
        Assert.assertEquals("Lucas", cliente1.getNombre());
        Assert.assertEquals("Muñoz", cliente1.getApellido());
        Assert.assertEquals(new Double(5000), cliente1.getCredito());

        cliente2.setNombre("Modificado");

        clienteRepository.update(cliente2);
        cliente2 = clienteRepository.getById(id2);
        Assert.assertEquals("Modificado", cliente2.getNombre());

        clienteRepository.delete(cliente1);
        clienteRepository.delete(cliente2);

        List<Cliente> clientes = clienteRepository.getAll();
        Assert.assertEquals(0, clientes.size());
    }
    
    @Test
    public void test(){
        Cliente cliente1 = new Cliente("Lucas", "Muñoz", 5000D);
        Cliente cliente2 = new Cliente("Lucas", "Castro", 3000D);
        Cliente cliente3 = new Cliente("Martin", "Castro", 3000D);
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        List<Cliente> clientes = clienteRepository.getByname("Lucas");
        
        clientes.forEach(System.out::println);
        Assert.assertEquals(2, clientes.size());        
    }
    
    @After
    public void after(){
//        System.err.println("ENTRANDO AL AFTER");
//        sessionFactory.close();
    }
}
