package ar.com.eduit.spring;

import ar.com.eduit.spring.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataService dataService = context.getBean(DataService.class);
        dataService.save("Hola");


//        DataRepository repository = context.getBean("dataSQLRepository", DataRepository.class);
//        repository.save("data sql");
//
//        DataRepository mongoRepository = context.getBean("dataDocumentRepository", DataRepository.class);
//        mongoRepository.save("data mongo");
    }
}
