package mx.com.gm.services;

import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {
    private PersonaDao dao;

    public ServicioPersonas() {
        this.dao = new PersonaDao();
    }
    
    public List<Persona> getAll(){
        return dao.getAll();
    }
}
