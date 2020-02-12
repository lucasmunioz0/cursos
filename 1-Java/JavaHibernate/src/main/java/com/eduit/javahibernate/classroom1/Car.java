package com.eduit.javahibernate.classroom1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "autos")
public class Car implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "trade", length = 100, unique = true)
    private String tradeMark;
    @Column(name = "model", length = 100, unique = false)
    private String model;

    public Car() {
    }

    public Car(Long id, String tradeMark, String model) {
        this.id = id;
        this.tradeMark = tradeMark;
        this.model = model;
    }

    public Car(String tradeMark, String model) {
        this.tradeMark = tradeMark;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", tradeMark=" + tradeMark + ", model=" + model + '}';
    }
}