package com.in28minutes.springbootjpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
public abstract class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Employee [%s]", name);
    }
}
