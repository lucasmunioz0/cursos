package com.eduit.javahibernate.laboratorio.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Entity
@Table(name = "autos")
@NamedQueries(value = {
        @NamedQuery(name = "laboratorio4", query = "From Auto a WHERE a.modelo like :modelo and a.marca like :marca"),
        @NamedQuery(name = "laboratorio6", query = "From Auto a WHERE a.precio > 10000")
})
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "au_id")
    private Long id;
    @Column(name = "au_marca")
    private String marca;
    @Column(name = "au_modelo")
    private String modelo;
    private Double precio;
    private LocalDate fechaVenta;

    public Auto() {
    }

    public Auto(String marca, String modelo, Double precio, LocalDate fechaVenta) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.fechaVenta = fechaVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return String.format("%d: %s %s, $%s (%s)", id, marca, modelo, new DecimalFormat("###,###.##").format(precio), fechaVenta.toString());
    }
}
