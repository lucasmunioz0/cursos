package com.sga.services;

import com.sga.dal.repositories.StudentRepository;
import com.sga.domain.Student;

public class StudentService extends BaseService<Student>{
    public StudentService() {        
        super(new StudentRepository());
    }

    @Override
    public Student getById(Long id) {
        return (Student) repository.getById(new Student(id));
    }
    
}
