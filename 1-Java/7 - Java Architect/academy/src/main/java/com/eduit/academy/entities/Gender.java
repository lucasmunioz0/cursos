package com.eduit.academy.entities;

import javax.persistence.*;

@Entity
@Table(name = "genders")
public class Gender {
    @Id
    @Column(name = "id_gender")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Gender() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gender{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
