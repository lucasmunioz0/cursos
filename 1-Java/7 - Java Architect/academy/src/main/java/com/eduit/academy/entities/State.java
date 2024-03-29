package com.eduit.academy.entities;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id
    @Column(name = "id_state")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public State() {
    }
    
    public State(Long id, String name) {
        this.id = id;
        this.name = name;
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
        return "State{" + "id=" + id + ", name=" + name + '}';
    }
}
