package ar.com.eduit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private DataRepository mongoRepository;
    private DataRepository sqlRepository;

    @Autowired
    public DataService(@Qualifier("dataDocumentRepository") DataRepository mongoRepository,
                       @Qualifier("dataSQLRepository") DataRepository sqlRepository) {
        this.mongoRepository = mongoRepository;
        this.sqlRepository = sqlRepository;
    }

    public void save(String mensaje){
        System.out.println("Saving on SQL...");
        sqlRepository.save(mensaje);
        System.out.println("Saving on NoSQL...");
        mongoRepository.save(mensaje);
        System.out.println("End save");
    }

}
