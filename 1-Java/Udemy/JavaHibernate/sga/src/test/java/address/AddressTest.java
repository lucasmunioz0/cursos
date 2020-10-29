package address;

import com.sga.dal.repositories.AddressRepository;
import com.sga.domain.Address;
import com.sga.services.AddressService;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressTest {

    private AddressRepository repository;
    private AddressService service;

    @Test
    public void shouldGetAll() {
        service = new AddressService();
//        List<Address> addresses = service.getAll();
//        
//        addresses.forEach(System.out::println);
//        
//        Assert.assertEquals(2, addresses.size());
    }

    @Test
    public void shouldSaveAnAddress() {
//        Address address = new Address("Test", "654", "TestCountry");
//        service = new AddressService();
//        List<Address> addresses = service.getAll();
//        int size = addresses.size();
//        service.insert(address);
//        addresses = service.getAll();
//        
//        Assert.assertEquals(size + 1, addresses.size());
    }

    @Test
    public void shouldUpdateAnAddress() {
//        service = new AddressService();
//        Address address = service.getById(5L);
//        String newCountry = "CountryTest";
//        address.setCountry(newCountry);
//        service.update(address);
//        address = service.getById(5L);
//
//        Assert.assertEquals(newCountry, address.getCountry());
    }

    @Test
    public void shouldDeleteAnAddress() {
//        service = new AddressService();
//        int size = service.getAll().size();
//        service.delete(new Address(5L));
//        Assert.assertEquals(size - 1, service.getAll().size());
    }
}
