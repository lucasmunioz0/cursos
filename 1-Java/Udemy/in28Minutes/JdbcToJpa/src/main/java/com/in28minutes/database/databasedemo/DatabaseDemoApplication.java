package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DatabaseDemoApplication implements CommandLineRunner {

    @Autowired
    private PersonJdbcDao personDao;

    @Autowired
    private PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = personJpaRepository.findById(10001);
        log.info(person.toString());
        Person newPerson = new Person("Lucas", "Muñoz", new Date());
        log.info("Before insert: " + newPerson.toString());
        newPerson = personJpaRepository.insert(newPerson);
        log.info("After insert: " + newPerson.toString());
        newPerson.setName("Martin");
        newPerson.setLocation("Argentina");
        log.info("Before update: " + newPerson.toString());
        newPerson = personJpaRepository.update(newPerson);
        log.info("After update: " + newPerson.toString());
        log.info("Before delete: " + newPerson.toString());
        personJpaRepository.deleteById(newPerson.getId());

        for (Person p: personJpaRepository.findAll()){
            System.out.println(p);
        }

//        List<Person> persons = personDao.findAll();
//        persons.forEach(System.out::println);
//        log.info("persons: " + persons);
//        log.info("person: " + personDao.findById(10003));
//        personDao.deleteById(10003);
//        persons = personDao.findAll();
//        persons.forEach(System.out::println);
//
//        Person person = new Person("Lucas", "Muñoz", new Date());
//        int id = personDao.insert(person);
//        log.info("ID INSERTADO: " + id);
//        person.setId(id);
//        log.info("PERSONA: " + person);
//        persons = personDao.findAll();
//        persons.forEach(System.out::println);
//        person.setName("Martin");
//        person.setLocation("Argentina");
//        personDao.update(person);
//        persons = personDao.findAll();
//        persons.forEach(System.out::println);
    }
}
