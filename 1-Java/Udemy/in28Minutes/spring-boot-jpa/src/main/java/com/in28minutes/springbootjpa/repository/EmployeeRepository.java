package com.in28minutes.springbootjpa.repository;

import com.in28minutes.springbootjpa.entity.Course;
import com.in28minutes.springbootjpa.entity.Employee;
import com.in28minutes.springbootjpa.entity.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Slf4j
@Transactional
public class EmployeeRepository {
    @Autowired
    EntityManager em;

    public Employee findById(Long id){
        return em.find(Employee.class, id);
    }

    public void insert(Employee employee){
        em.persist(employee);
    }

    public List<Employee> findAllPartTimeEmployess(){
        return em.createQuery("SELECT e FROM PartTimeEmployee e", Employee.class).getResultList();
    }

    public List<Employee> findAllFullTimeEmployess(){
        return em.createQuery("SELECT e FROM FullTimeEmployee e", Employee.class).getResultList();
    }
}