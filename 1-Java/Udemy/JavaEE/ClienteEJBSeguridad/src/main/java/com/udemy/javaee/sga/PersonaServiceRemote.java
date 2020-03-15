/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udemy.javaee.sga;

import java.util.List;

/**
 *
 * @author Lucas
 */
public interface PersonaServiceRemote {
    public List<Persona> findAll();
    public Persona getById(Persona persona);
    public void insert(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}
