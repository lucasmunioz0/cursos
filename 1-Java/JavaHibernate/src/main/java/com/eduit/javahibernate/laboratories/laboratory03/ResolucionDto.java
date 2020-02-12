package com.eduit.javahibernate.laboratories.laboratory03;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class ResolucionDto {
    private Long idAuto;
    private String model;
    private Double price;
    private LocalDate saleDate;
    private String tradeMark;
    private Long idConcesionaria;
    private String direction;
    private String name;

    public ResolucionDto() {
    }

    public Long getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Long idAuto) {
        this.idAuto = idAuto;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public String getTradeMark() {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    public Long getIdConcesionaria() {
        return idConcesionaria;
    }

    public void setIdConcesionaria(Long idConcesionaria) {
        this.idConcesionaria = idConcesionaria;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ResolucionDto{" +
                "idAuto=" + idAuto +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", saleDate=" + saleDate +
                ", tradeMark='" + tradeMark + '\'' +
                ", idConcesionaria=" + idConcesionaria +
                ", direction='" + direction + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
