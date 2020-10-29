package com.sga.dal.repositories;

import com.sga.domain.Assignment;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AssignmentRepository extends BaseRepository<Assignment>{
    
    @Override
    public List<Assignment> getAll(){
        Query query = em.createQuery("FROM Assignment");
        return query.getResultList();
    }
    
    public Assignment getById(Assignment assignment){
        return em.find(Assignment.class, assignment.getId());
    }
}
