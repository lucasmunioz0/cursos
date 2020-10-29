package com.sga.dal.repositories;

import static com.sga.dal.repositories.BaseRepository.em;
import com.sga.domain.Student;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class StudentRepository extends BaseRepository<Student>{
    @Override
    public List<Student> getAll(){
        Query query = em.createQuery("FROM Student");
        return query.getResultList();
    }
    
    public Student getById(Student student){
        return em.find(Student.class, student.getId());
    }
}
