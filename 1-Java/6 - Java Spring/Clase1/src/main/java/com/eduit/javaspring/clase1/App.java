package com.eduit.javaspring.clase1;

import com.eduit.javaspring.clase1.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataRepository dataRepository = context.getBean("dataSQLRepository", DataRepository.class);
        dataRepository.save("data sql");

        System.out.println(dataRepository.hashCode());

        dataRepository = context.getBean("dataSQLRepository", DataRepository.class);

        System.out.println(dataRepository.hashCode());

        DataRepository mongoRepository = context.getBean("dataDocumentRepository", DataRepository.class);

        mongoRepository.save("data mongo");

        System.out.println(mongoRepository.hashCode());

        mongoRepository = context.getBean("dataDocumentRepository", DataRepository.class);

        System.out.println(mongoRepository.hashCode());

        final DataService bean = context.getBean(DataService.class);
        bean.save("hola");

    }
}
