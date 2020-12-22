package com.hibernate.set;

import com.hibernate.set.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.Set;

@SpringBootApplication
public class SetApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(SetApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
        Set<String> theImages = tempStudent.getImages();
        theImages.add("photo1.jpg");
        theImages.add("photo2.jpg");
        theImages.add("photo3.jpg");
        System.out.println("Saving the student and images..");
        em.persist(tempStudent);
    }
}
