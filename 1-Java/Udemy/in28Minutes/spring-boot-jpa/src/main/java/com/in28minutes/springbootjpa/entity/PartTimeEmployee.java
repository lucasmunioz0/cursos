package com.in28minutes.springbootjpa.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "part_time_employees")
@Data
public class PartTimeEmployee extends Employee{
    private BigDecimal hourlyWage;
    protected PartTimeEmployee(){

    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
