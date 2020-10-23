package com.eduit.academy.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "countries") 
public class Country {
    @Id
    @Column(name = "id_country")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_country")
    private List<State> states;

    public Country() {
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

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" + "id=" + id + ", name=" + name + ", states=" + states + '}';
    }
    
    
    
}
