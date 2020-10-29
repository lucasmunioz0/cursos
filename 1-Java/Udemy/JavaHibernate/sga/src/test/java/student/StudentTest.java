package student;

import com.sga.dal.repositories.StudentRepository;
import com.sga.domain.Address;
import com.sga.domain.Contact;
import com.sga.domain.Student;
import com.sga.services.AddressService;
import com.sga.services.ContactService;
import com.sga.services.StudentService;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
    private static StudentRepository repository;
    private StudentService service;
    private ContactService contactService;
    private AddressService addressService;
    
    @BeforeClass
    public static void start(){
        repository = new StudentRepository();
    }
    
    @Test
    public void shouldGetAllStudents(){        
//        List<Student> students = repository.getAll();
//        students.forEach(student -> System.out.println(student.getName()));
//        
//        Assert.assertEquals(4, students.size());
    }
    
    @Test
    public void shouldSaveAnStudent(){
//        List<Student> students = repository.getAll();
//        Student student = new Student("Lucas", "Muñoz");
//        repository.insert(student);        
//        List<Student> students2 = repository.getAll();
//                
//        Assert.assertEquals(students.size() + 1, students2.size());
    }
    
    @Test
    public void shouldUpdateAnStudent(){
//        Student student = repository.getById(new Student(1L));
//        String name = "New Name";
//        student.setName(name);
//        repository.update(student);
//        student = repository.getById(new Student(1L));
//                
//        Assert.assertEquals(name, student.getName());
    }
    
    @Test
    public void shouldDeleteAnStudent(){
//        List<Student> students = repository.getAll();
//        int size = students.size();
//        repository.delete(students.get(0));        
//        students = repository.getAll();
//        
//        Assert.assertEquals(size - 1, students.size());
    }
    
    @Test
    public void shouldInsertAnStudentCascade(){
//        service = new StudentService();
//        addressService = new AddressService();
//        contactService = new ContactService();
//        
//        Student student = new Student("Test", "Test Last Name");
//        Address address = new Address("Test", "17894", "TestCountry");
//        Contact contact = new Contact("54645", "test@gmail.com");
//        student.setAddress(address);
//        student.setContact(contact);
//        
//        int studentSize = service.getAll().size();
//        int addressSize = addressService.getAll().size();
//        int contactSize = contactService.getAll().size();
//        service.insert(student);
//        
//        Assert.assertEquals(studentSize + 1, service.getAll().size());
//        Assert.assertEquals(addressSize + 1, addressService.getAll().size());
//        Assert.assertEquals(contactSize + 1, contactService.getAll().size());
    }
    
    @Test
    public void shouldDeleteAnStudentCascade(){
//        service = new StudentService();
//        
//        Student student = service.getById(8L);
//        
//        int studentSize = service.getAll().size();
//
//        service.delete(student);
//        
//        Assert.assertEquals(studentSize - 1, service.getAll().size());
    }
}
