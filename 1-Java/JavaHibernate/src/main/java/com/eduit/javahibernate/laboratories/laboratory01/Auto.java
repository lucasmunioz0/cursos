package com.eduit.javahibernate.laboratories.laboratory01;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class Auto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String tradeMark;
    @Column(nullable = false, length = 50)
    private String model;
    @Column(name = "sale_Date")
    private LocalDate saleDate;
    private Double price;

    public Auto(String tradeMark, String model, LocalDate saleDate, Double price) {
        this.tradeMark = tradeMark;
        this.model = model;
        this.saleDate = saleDate;
        this.price = price;
    }

    public Auto() {
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

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s %s $%.2f", id, tradeMark, model, saleDate.format(DateTimeFormatter.ISO_DATE), price);
    }
}