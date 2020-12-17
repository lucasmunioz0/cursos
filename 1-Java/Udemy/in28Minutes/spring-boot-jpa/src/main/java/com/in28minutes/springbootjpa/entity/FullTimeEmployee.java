package com.in28minutes.springbootjpa.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "full_time_employees")
@Data
public class FullTimeEmployee extends Employee{
    private BigDecimal salary;
    protected FullTimeEmployee(){

    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
