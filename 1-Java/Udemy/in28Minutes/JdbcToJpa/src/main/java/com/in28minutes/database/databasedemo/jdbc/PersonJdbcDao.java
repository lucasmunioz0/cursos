package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Person WHERE id=?", new BeanPropertyRowMapper<Person>(Person.class), new Object[]{id});
    }

    public void deleteById(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) " + "values(?,  ?, ?, ?)",
                new Object[] { person.getId(), person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()) });
    }

    public int update(Person person){
        return jdbcTemplate.update("UPDATE PERSON set NAME=?, LOCATION=?, BIRTH_DATE=? where ID=?; ",
                new Object[]{person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
    }
}
