package com.udemy.sga.controllers;

import com.udemy.sga.domain.Persona;
import com.udemy.sga.services.PersonaService;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

@RequestScoped
@Named(value = "personaBean")
public class PersonaBean {
    
    @Inject
    private PersonaService personaService;
    private Persona personaSeleccionada;
    private List<Persona> personas;
    private Logger log = LogManager.getRootLogger();

    public PersonaBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        this.personas = personaService.findAll();
        log.debug("Personas recuperadas \n" + personas);
        for (Persona persona : personas) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(PersonaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.personaSeleccionada = new Persona();
    }
    
    public void editListener(RowEditEvent event){
        Persona persona = (Persona) event.getObject();
        personaService.update(persona);
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public void agregarPersona(){
        this.personaService.insert(personaSeleccionada);
        this.personas.add(personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
    public void eliminarPersona(){
        this.personaService.delete(personaSeleccionada);
        this.personas.remove(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }
}
