package com.eduit.javaspring.clase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    private DataRepository mongoRepository;
    private DataRepository sqlDataRepository;

    @Autowired
    public DataService(@Qualifier("dataDocumentRepository") DataRepository mongoRepository,
                       @Qualifier("dataSQLRepository") DataRepository sqlDataRepository) {
        this.mongoRepository = mongoRepository;
        this.sqlDataRepository = sqlDataRepository;
    }

    public void save(String data){
        System.out.println("Saving on sql");
        sqlDataRepository.save(data);
        System.out.println("Saving on mongo");
        mongoRepository.save(data);
        System.out.println("end save");
    }
}
