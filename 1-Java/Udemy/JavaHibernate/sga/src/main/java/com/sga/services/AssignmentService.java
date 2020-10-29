package com.sga.services;

import com.sga.dal.repositories.AssignmentRepository;
import com.sga.domain.Assignment;

public class AssignmentService extends BaseService<Assignment>{
    private AssignmentRepository repository;

    public AssignmentService() {        
        super(new AssignmentRepository());
    }

    @Override
    public Assignment getById(Long id) {
        return (Assignment) repository.getById(new Assignment(id));
    }
}
